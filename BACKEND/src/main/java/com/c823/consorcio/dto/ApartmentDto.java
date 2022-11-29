package com.c823.consorcio.dto;

import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentDto {

  private Long apartmentId;
  private Long apartmentNumber;
  private String floor;
  private UserEntity user;
  private AccountEntity account;

}
