package com.c823.consorcio.service;

import com.c823.consorcio.entity.AccountEntity;

import com.c823.consorcio.entity.ApartmentEntity;

public interface IAccountService {

  Object addAccount(ApartmentEntity apartment, String email);

  AccountEntity createAccount(ApartmentEntity apartment);

  double calculateBalance(Long accountId);
}
