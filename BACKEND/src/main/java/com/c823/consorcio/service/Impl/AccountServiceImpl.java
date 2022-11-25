package com.c823.consorcio.service.Impl;

import com.c823.consorcio.entity.AccountEntity;

import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.TransactionEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.exception.ParamNotFound;
import com.c823.consorcio.enums.TypeTransaction;
import com.c823.consorcio.repository.IApartmentRepository;
import com.c823.consorcio.repository.ITransactionRepository;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.repository.IaccountRepository;
import com.c823.consorcio.service.IAccountService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
  @Autowired
  IUserRepository userRepository;
  @Autowired
  IaccountRepository iaccountRepository;
  @Autowired
  IApartmentRepository iApartmentRepository;
  @Autowired
  ITransactionRepository iTransactionRepository;





  @Override

  public String addAccount(ApartmentEntity apartment, String email) {

 

    String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = this.userRepository.findByEmail(email);
    List<AccountEntity> accounts = this.iaccountRepository.findAllByUser(user);
   /* if (user == null) {
      throw new ParamNotFound("ID invalid");

    }*/

    AccountEntity account = createAccount(apartment);
    UserEntity log = this.userRepository.findByEmail(email);
    account.setUser(log);
    account.setApartment(apartment);

    this.iaccountRepository.save(account);
    log.addAccount(account);
    this.userRepository.save(log);
    return HttpStatus.CREATED.getReasonPhrase();


  }


  @Override
  public AccountEntity createAccount(ApartmentEntity apartment) {

    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setCreationDate(new Date());
    accountEntity.setBalance(0.0);
    accountEntity.setUpdateDate(new Date());
    return accountEntity;
  }

  @Override
  public double calculateBalance(Long accountId) {
    double totalPayment = 0;
    double totalIncome = 0;
    AccountEntity account = iaccountRepository.findByAccountId(accountId);
    List<TransactionEntity> payments = iTransactionRepository.findAllByAccountIdAndType(account,
        TypeTransaction.PAYMENT);
    List<TransactionEntity> incomes = transactionRepository.findAllByAccountIdAndType(account, TypeTransaction.INCOME);

    for (int i = 0; i < payments.size(); i++) {

      TransactionEntity payment;
      payment = payments.get(i);

      totalPayment = totalPayment + payment.getAmount();

    }

    for (int i = 0; i < incomes.size(); i++) {

      TransactionEntity income;
      income = incomes.get(i);

      totalIncome = totalIncome + income.getAmount();

    }

    return 0;
  }


}
