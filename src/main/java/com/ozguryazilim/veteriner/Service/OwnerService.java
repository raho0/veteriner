package com.ozguryazilim.veteriner.Service;

import com.ozguryazilim.veteriner.Dto.OwnerDto;
import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import com.ozguryazilim.veteriner.Repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> addOwner(OwnerEntity owner) {
        owner.setPassword(this.passwordEncoder.encode(owner.getPassword()));
        return new ResponseEntity<>(ownerRepository.save(owner), HttpStatus.CREATED);
    }

    public ResponseEntity<List<OwnerEntity>> getOwners() {
        return ResponseEntity.ok(ownerRepository.findAll());
    }

    public OwnerEntity findByNameAndPassword(String name, String password) throws UsernameNotFoundException {
        OwnerEntity user = ownerRepository.findByName(name);

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User not found");
    }

    public ResponseEntity<OwnerEntity> getOwnerByName(String name) {
        return ResponseEntity.ok(ownerRepository.findByName(name));
    }

    public ResponseEntity<List<OwnerDto>> getOwnerById(Long id) {
        return ResponseEntity.ok(ownerRepository.findById(id).stream().map(OwnerDto::new).collect(Collectors.toList()));
    }
}
