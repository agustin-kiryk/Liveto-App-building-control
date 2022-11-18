package com.c823.consorcio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class ApartmentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private int streetNumber;
    //apartment ej: 2C
    private String apartment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ApartmentEntity() {
    }

    public ApartmentEntity(String street, int streetNumber, String apartment) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartment = apartment;
    }
}
