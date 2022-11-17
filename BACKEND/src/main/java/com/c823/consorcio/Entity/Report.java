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
public class Report {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int ticketNro;

    private Date fechaCreacion;
    //se podria usar un enums para crear varios asuntos y estados
    private String asunto;
    private String estado;
    private String detalle;
    private String unidadEspacio;


    public Report() {
    }

    public Report(int ticketNro, Date fechaCreacion, String asunto, String detalle, String unidadEspacio, String estado) {
        this.ticketNro = ticketNro;
        this.fechaCreacion = fechaCreacion;
        this.asunto = asunto;
        this.detalle = detalle;
        this.unidadEspacio = unidadEspacio;
        this.estado = estado;
    }

}
