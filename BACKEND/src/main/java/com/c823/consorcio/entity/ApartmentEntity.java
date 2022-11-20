package com.c823.consorcio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APARTMENT_ID")
    private long apartmentId;

    @Column(name = "APARTMENT_NUMBER")
    private Long apartmentNumber;

    @Column(name = "STREET")
    private String street;

    @Column(name = "STREET_NUMBER")
    private int streetNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    public ApartmentEntity() {
    }
}


