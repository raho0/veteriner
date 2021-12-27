package com.ozguryazilim.veteriner.Dto;

import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class OwnerDto {
    private String name;
    private String contact;
    private String mobile_no;
    private String email;
    private List<AnimalDto> animalList = new ArrayList<>();

    public OwnerDto(OwnerEntity owner) {
        this.setName(owner.getName());
        this.setContact(owner.getContact());
        this.setMobile_no(owner.getMobileNo());
        this.setEmail(owner.getEmail());
        this.setAnimalList(owner.getAnimalEntities().stream().map(AnimalDto::new).collect(Collectors.toList()));
    }
}
