package com.c823.consorcio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter @Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaReserva;
    private UserProfile usuario;

    //para turnoReserva como opcion se podría crear un enum que contenga los tres tipos de turnos
    private String turnoReserva;

    public Reservation(){
    }

    public Reservation(Date fechaReserva, String turnoReserva) {
        this.fechaReserva = fechaReserva;
        this.turnoReserva = turnoReserva;
    }
}
