package com.ozguryazilim.veteriner.Controller;

import com.ozguryazilim.veteriner.Dto.AnimalDto;
import com.ozguryazilim.veteriner.Entity.AnimalEntity;
import com.ozguryazilim.veteriner.Entity.CustomUserDetail;
import com.ozguryazilim.veteriner.Service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @Secured({"ROLE_admin", "ROLE_user"})
    @PostMapping("/add")
    public ResponseEntity<?> addAnimal(@AuthenticationPrincipal CustomUserDetail user,
                                       @RequestBody AnimalDto animal) {
        return animalService.addAnimal(animal, user.getId());
    }

    @Secured({"ROLE_admin", "ROLE_user"})
    @PutMapping("/update")
    public ResponseEntity<?> updateAnimal(@RequestBody AnimalEntity animal) {
        return animalService.save(animal);
    }

    @Secured("ROLE_admin")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    // get current user's animals or
    // get current user's animal by name
    @Secured({"ROLE_admin", "ROLE_user"})
    @GetMapping("/get")
    public ResponseEntity<?> getAnimalsByOwnerId(@AuthenticationPrincipal CustomUserDetail user,
                                                 @RequestParam(required = false) String name) {
        if (name == null)
            return animalService.getAnimalsByOwnerId(user.getId());

        return animalService.getAnimalByName(name, user.getId());
    }


    // Get all Animals or
    // Get all animals by name or
    // Get all animals by name and ownerId
    @Secured("ROLE_admin")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAnimals(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Long ownerId) {

        if (name == null && ownerId == null)
            return animalService.getAnimals();

        else if (ownerId == null)
            return animalService.getAllAnimalsByName(name);

        return animalService.getAllAnimalsByNameAndOwnerId(name, ownerId);
    }

}
