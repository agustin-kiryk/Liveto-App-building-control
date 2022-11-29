package com.c823.consorcio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNTS")
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE account_id=?")
@Where(clause = "deleted=false")

public class AccountEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "BALANCE", nullable = false)
    private double balance;

    @Column(name = "CREATION_DATE", nullable = false)

    private Date creationDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<TransactionEntity> transactions = new ArrayList<>();


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartment;


    private boolean deleted = Boolean.FALSE;
}
