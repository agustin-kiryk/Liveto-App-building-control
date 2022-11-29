package com.c823.consorcio.dto;

import lombok.Data;

@Data
public class BillPaymentDto {

  private Double amount;
  private String description;
  private Long destinationAccountId;

}
