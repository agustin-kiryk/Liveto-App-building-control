package com.c823.consorcio.mapper;

import com.c823.consorcio.dto.AccountDto;
import com.c823.consorcio.entity.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountMap {

  public List<AccountDto> accountEntityList2DtoList(List<AccountEntity> accounts) {
    List<AccountDto> accountDtos = new ArrayList<>();
    AccountDto accountDto;
    for (AccountEntity account : accounts){
      accountDto = new AccountDto();
      accountDto.setAccountId(account.getAccountId());
      accountDto.setBalance(account.getBalance());
      accountDto.setCreationDate(account.getCreationDate());
      accountDto.setUpdateDate(account.getUpdateDate());
      //accountDto.setApartment(account.getApartment());

      accountDtos.add(accountDto);
    }
    return accountDtos;
  }
}
