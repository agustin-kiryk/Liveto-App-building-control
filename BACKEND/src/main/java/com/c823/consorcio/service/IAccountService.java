package com.c823.consorcio.service;

import com.c823.consorcio.entity.AccountEntity;

import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.enums.TypeTransaction;

public interface IAccountService {

  Object addAccount(ApartmentEntity apartment, String email);

  AccountEntity createAccount(ApartmentEntity apartment);

  double calculateBalance(Long accountId);

  void updateBalance(Long accountId, Double amount, TypeTransaction type);
}
