package com.c823.consorcio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dpto;
    private String domicilioCalle;

    public UserProfile() {
    }

    public UserProfile(Long id, String nombre, String apellido, String email, String dpto, String domicilioCalle) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dpto = dpto;
        this.domicilioCalle = domicilioCalle;
    }

}
