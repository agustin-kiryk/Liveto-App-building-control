package com.c823.consorcio.service;

import com.c823.consorcio.entity.AccountEntity;

public interface IAccountService {

  Object addAccount(Long apartmentNumber, String email);

  AccountEntity createAccount(Long apartmentId);
}
