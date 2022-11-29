package com.c823.consorcio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE user_id=?" )
@Where(clause = "deleted=false")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CREATION_DATE", nullable = false)
    @CreationTimestamp
    private Date creationDate;

    @OneToMany(mappedBy = "user", cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<ApartmentEntity> apartments = new ArrayList<>();
    //Metodo para que el usuario agregue departamentos
    public void addApartment(ApartmentEntity apartment){
        apartments.add(apartment);
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts = new ArrayList<>();
    //Metodo para que el usuario agregue cuentas
    public void addAccount(AccountEntity account){
        accounts.add(account);
    }




    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    private boolean deleted = Boolean.FALSE;




}
