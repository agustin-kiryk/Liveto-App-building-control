package com.c823.consorcio.entity;

import com.c823.consorcio.enums.RoleName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME",nullable = false,unique = true)
    private RoleName roleName;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER) //TODO: "ver cascade"
    private List<UserEntity> users = new ArrayList<>();
}
