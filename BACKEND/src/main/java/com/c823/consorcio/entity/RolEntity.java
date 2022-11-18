package com.c823.consorcio.entity;

import com.c823.consorcio.enums.RolName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public RolEntity() {
    }

    public RolEntity(RolName rolName){
        this.rolName = rolName;
    }

}
