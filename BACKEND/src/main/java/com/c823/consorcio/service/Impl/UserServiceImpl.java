package com.c823.consorcio.service.Impl;


import com.c823.consorcio.dto.AccountBasicDto;
import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.mapper.AccountMap;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.service.IAccountService;
import com.c823.consorcio.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository iUserRepository;
  @Autowired
  private IAccountService iAccountService;
  @Autowired
  private AccountMap accountMap;


  @Override
  public List<AccountBasicDto> getAccountsBalance() {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = this.iUserRepository.findByEmail(email);
    List<AccountEntity> accounts = user.getAccounts();
    for(int i = 0; i< accounts.size(); i++){
      AccountEntity account;
      account = accounts.get(i);
      account.setBalance(this.iAccountService.calculateBalance(account.getAccountId()));
    }
    List<AccountBasicDto> accountsDto = this.accountMap.accountEntityList2BasicDto(accounts);
    return accountsDto;

  }
}
