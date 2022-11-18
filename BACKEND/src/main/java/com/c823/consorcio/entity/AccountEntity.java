package com.c823.consorcio.entity;

import javax.persistence.*;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public AccountEntity() {
    }

    public AccountEntity(double balance) {
        this.balance = balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
