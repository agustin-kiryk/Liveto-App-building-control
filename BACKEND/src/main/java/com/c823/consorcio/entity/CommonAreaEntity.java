package com.c823.consorcio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CommonAreaEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "AMENITY_ID")
    private Long amenityId;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservation;

    public CommonAreaEntity() {
    }

    public CommonAreaEntity(String name) {
        this.name = name;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

}
