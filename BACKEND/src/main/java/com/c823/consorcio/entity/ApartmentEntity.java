package com.c823.consorcio.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ApartmentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "APARTMENT_ID")
    private long apartmentId;

    @Column(name = "STREET")
    private String street;

    @Column(name= "STREET_NUMBER")
    private int streetNumber;

    //apartment ej: 2C
    @Column(name = "APARTMENT_NUMBER")
    private String apartment;

    @ManyToOne
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
