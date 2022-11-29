package com.c823.consorcio.dto;

import com.c823.consorcio.enums.TypeTransaction;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

  private Long transactionId;
  private Double amount;
  private TypeTransaction type;
  private String description;
  private Long accountId;
  private Long destinationAccountId;
  private Date transactionDate;

}
