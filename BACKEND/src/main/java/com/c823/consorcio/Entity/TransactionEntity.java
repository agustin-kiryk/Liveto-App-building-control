package com.c823.consorcio.Entity;

import com.c823.consorcio.enums.TypeTransaction;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTIONS")

public class TransactionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TRANSACTION_ID", nullable = false)
  private Long transactionId;

  @Column(name = "AMOUNT", nullable = false)
  private Double amount;

  @Column(name = "TYPE_TRANSACTION")
  private TypeTransaction type;

  @Column(name = "DESCRIPTION")
  private String description;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "ACCOUNT_ID")
  private AccountEntity accountId;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "USER_ID")
  private UserEntity userEntity;

  @CreationTimestamp
  @Column(name = "TRANSACTION_DATE")
  private Date transactionDate;


}
