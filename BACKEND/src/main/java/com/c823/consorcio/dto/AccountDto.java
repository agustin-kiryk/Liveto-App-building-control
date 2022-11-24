package com.c823.consorcio.dto;

import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.UserEntity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

  private Long accountId;
  private double balance;
  private Date creationDate;
  private Date updateDate;
  private UserEntity user;
  private ApartmentEntity apartment;

}
