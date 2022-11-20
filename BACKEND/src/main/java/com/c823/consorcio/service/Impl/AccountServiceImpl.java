package com.c823.consorcio.service.Impl;

import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.exception.ParamNotFound;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.repository.IaccountRepository;
import com.c823.consorcio.service.IAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
  @Autowired
  IUserRepository userRepository;
  @Autowired
  IaccountRepository iaccountRepository;


  @Override
  public void addAccount(String email, ResponseUserDto userDto) {
    String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = this.userRepository.findByEmail(email);
    List<AccountEntity> accounts = this.iaccountRepository.findAllByUser(user);
    if (user == null) {
      throw new ParamNotFound("ID invalid");
    }
    AccountEntity account = createAccount();
    account.setApartment(userDto.getApartmentNumber());

  }
}
