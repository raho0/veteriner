package com.ozguryazilim.veteriner.Dto;

import com.ozguryazilim.veteriner.Entity.AnimalEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalDto {
    private String type;
    private String kind;
    private String name;
    private Integer age;
    private String description;

    public AnimalDto(AnimalEntity animal) {
        this.setType(animal.getType());
        this.setKind(animal.getKind());
        this.setName(animal.getName());
        this.setAge(animal.getAge());
        this.setDescription(animal.getDescription());
    }
}
