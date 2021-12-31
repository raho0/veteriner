package com.ozguryazilim.veteriner;

import com.ozguryazilim.veteriner.Entity.AnimalEntity;
import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import com.ozguryazilim.veteriner.Service.AnimalService;
import com.ozguryazilim.veteriner.Service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements ApplicationRunner {


    private final AnimalService animalService;
    private final OwnerService ownerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        OwnerEntity admin = new OwnerEntity();
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setContact("turkey");
        admin.setMobileNo("+90");
        admin.setEmail("admin@mail.com");
        admin.setRole("admin");

        ownerService.addOwner(admin);

        OwnerEntity user = new OwnerEntity();
        user.setName("user");
        user.setPassword("user");
        user.setContact("turkey");
        user.setMobileNo("+90");
        user.setEmail("user@mail.com");
        user.setRole("user");

        ownerService.addOwner(user);

        AnimalEntity animal1 = new AnimalEntity();
        animal1.setAge(1);
        animal1.setName("test1");
        animal1.setDescription("test1 description");
        animal1.setKind("test1 kind");
        animal1.setType("test1 type");
        animal1.setOwnerId(admin.getId());

        animalService.save(animal1);

        AnimalEntity animal2 = new AnimalEntity();
        animal2.setAge(2);
        animal2.setName("test2");
        animal2.setDescription("test2 description");
        animal2.setKind("test2 kind");
        animal2.setType("test2 type");
        animal2.setOwnerId(admin.getId());

        animalService.save(animal2);

        AnimalEntity animal3 = new AnimalEntity();
        animal3.setAge(3);
        animal3.setName("test3");
        animal3.setDescription("test3 description");
        animal3.setKind("test3 kind");
        animal3.setType("test3 type");
        animal3.setOwnerId(user.getId());

        animalService.save(animal3);

        AnimalEntity animal4 = new AnimalEntity();
        animal4.setAge(4);
        animal4.setName("test4");
        animal4.setDescription("test4 description");
        animal4.setKind("test4 kind");
        animal4.setType("test4 type");
        animal4.setOwnerId(user.getId());

        animalService.save(animal4);
    }
}
