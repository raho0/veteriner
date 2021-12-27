package com.ozguryazilim.veteriner.Service;

import com.ozguryazilim.veteriner.Dto.AnimalDto;
import com.ozguryazilim.veteriner.Entity.AnimalEntity;
import com.ozguryazilim.veteriner.Repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public ResponseEntity<?> addAnimal(AnimalDto animal, Long id) {
        AnimalEntity animalEntity = new AnimalEntity(animal, id);
        return new ResponseEntity<>(animalRepository.save(animalEntity), HttpStatus.CREATED);
    }

    public ResponseEntity<List<AnimalEntity>> getAnimals() {
        return ResponseEntity.ok(animalRepository.findAll());
    }

    public ResponseEntity<List<AnimalDto>> getAnimalsByOwnerId(Long id) {
        return ResponseEntity.ok(animalRepository.findAllByOwnerId(id).stream().map(AnimalDto::new).collect(Collectors.toList()));
    }

    public ResponseEntity<AnimalDto> getAnimalByName(String name, Long id) {
        return ResponseEntity.ok(new AnimalDto(animalRepository.findByNameAndOwnerId(name, id)));
    }

    public ResponseEntity<List<AnimalEntity>> getAllAnimalsByName(String name) {
        return ResponseEntity.ok(animalRepository.findAllByName(name));
    }

    public ResponseEntity<?> getAllAnimalsByNameAndOwnerId(String name, Long userId) {
        return ResponseEntity.ok(animalRepository.findAllByNameAndOwnerId(name, userId));
    }

    public ResponseEntity<?> save(AnimalEntity animalEntity) {
        return ResponseEntity.ok(animalRepository.save(animalEntity));
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}
