# veteriner-api-ozguryazilim

- ## Creating User (/register)

You can create Owner with admin or user role

- ## Authorization Request (/auth):

You must be authorized for the requests  

You can use default owners

```
http://localhost:8080/auth
```

for admin role;
```json
{
  "name": "admin",
  "password": "admin"
}
```

for user role;
```json
{
  "name": "user",
  "password": "user"
}
```

this request will be return JWT token.

- ## Get user detail (/api/owner): 

```
http://localhost:8080/api/owner/get
```

```json
[
	{
		"name": "admin",
		"contact": "turkey",
		"mobile_no": "+90",
		"email": "admin@mail.com",
		"animalList": [
			{
				"type": "test1 type",
				"kind": "test1 kind",
				"name": "test1",
				"age": 1,
				"description": "test1 description"
			},
			{
				"type": "test2 type",
				"kind": "test2 kind",
				"name": "test2",
				"age": 2,
				"description": "test2 description"
			}
		]
	}
]
```

if you have admin role you can access this requests;

for specific owner 
```
http://localhost:8080/api/owner/getBy?name=user
```

for all owners
```
http://localhost:8080/api/owner/getAll
```

- ## Animal request (/api/animal)

all roles can add animal or update

```
http://localhost:8080/api/animal/add
```
```json
{
	"type":"test",
	"kind":"test",
	"name":"test",
	"age": 5,
	"description":"test"
}
```

admin role can delete animal by animal id 
```
http://localhost:8080/api/animal/delete/1
```

all roles can get their own animal or a specific animal by name
```
http://localhost:8080/api/animal/get?name=test1
```

```json
{
	"type": "test1 type",
	"kind": "test1 kind",
	"name": "test1",
	"age": 1,
	"description": "test1 description"
}
```


admin role can get all animals or   
get all animals by name or  
get all animals by owner id

```
http://localhost:8080/api/animal/getAll
```
```
http://localhost:8080/api/animal/getAll?name=test1
```
```
http://localhost:8080/api/animal/getAll?ownerId=1
```
```
http://localhost:8080/api/animal/getAll?name=test1&ownerId=1
```
```json
[
	{
		"id": 1,
		"type": "test1 type",
		"kind": "test1 kind",
		"name": "test1",
		"age": 1,
		"description": "test1 description",
		"ownerId": 1
	}
]
```

----

You can access H2 database at: 

```
http://localhost:8080/h2-console 
```

JDBC config:

```
JDBC URL: "jdbc:h2:mem:test"
User Name: "sa"
Password: ""
```

---

