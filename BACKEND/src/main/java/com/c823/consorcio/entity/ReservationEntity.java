package com.c823.consorcio.entity;

import com.c823.consorcio.enums.Turn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Date reservationDate;
    @Enumerated (EnumType.STRING)
    private Turn turn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ReservationEntity(){
    }
    public ReservationEntity(Date reservationDate, Turn turn) {
        this.reservationDate = reservationDate;
        this.turn = turn;
    }
}
