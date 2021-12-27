package com.ozguryazilim.veteriner.Repository;

import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    OwnerEntity findByName(String username);
}
