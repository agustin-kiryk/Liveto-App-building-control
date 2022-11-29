package com.c823.consorcio.mapper;

import com.c823.consorcio.dto.AccountBasicDto;
import com.c823.consorcio.dto.AccountDto;
import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.repository.ITransactionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMap {
  @Autowired
  private ITransactionRepository iTransactionRepository;
  @Autowired
  private TransactionMap transactionMap;

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

  public List<AccountBasicDto> accountEntityList2BasicDto(List<AccountEntity> entities) {
    List<AccountBasicDto> accounts = new ArrayList<>();
    for(AccountEntity entity : entities){
      accounts.add(accountEntityBasic2Dto(entity));
    }
    return accounts;
  }

  private AccountBasicDto accountEntityBasic2Dto(AccountEntity entity) {
    AccountBasicDto dto = new AccountBasicDto();

    dto.setAccountId(entity.getAccountId());
    dto.setBalance(entity.getBalance());
    //dto.setTransaction(this.transactionMap.entityList2BasicDtoList(entity.getTransactions()));//TODO: COMPLETAR METODO EN MAPTRANSACTION

    return dto;
  }
}
