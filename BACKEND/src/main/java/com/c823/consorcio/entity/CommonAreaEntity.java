package com.c823.consorcio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class CommonAreaEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
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
