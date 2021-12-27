package com.ozguryazilim.veteriner.Entity;

import com.ozguryazilim.veteriner.Dto.AnimalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "Animal")
@Data
@NoArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "kind")
    private String kind;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "description")
    private String description;

    private Long ownerId;


    public AnimalEntity(AnimalDto animal, Long id) {
        this.setType(animal.getType());
        this.setKind(animal.getKind());
        this.setName(animal.getName());
        this.setAge(animal.getAge());
        this.setDescription(animal.getDescription());
        this.setOwnerId(id);
    }
}
