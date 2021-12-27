package com.ozguryazilim.veteriner.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "owner")
@Data
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "contact")
    private String contact;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(targetEntity = AnimalEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    private List<AnimalEntity> animalEntities;

}
