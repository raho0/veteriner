package com.ozguryazilim.veteriner.Repository;

import com.ozguryazilim.veteriner.Entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
    List<AnimalEntity> findAllByOwnerId(Long ownerId);
    AnimalEntity findByNameAndOwnerId(String name, Long ownerId);
    List<AnimalEntity> findAllByName(String name);
    List<AnimalEntity> findAllByNameAndOwnerId(String name, Long ownerId);

}
