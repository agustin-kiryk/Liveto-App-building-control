package com.c823.consorcio.service.Impl;

import com.c823.consorcio.auth.exception.ParamNotFound;
import com.c823.consorcio.dto.BillPaymentDto;
import com.c823.consorcio.dto.TransactionDto;
import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.TransactionEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.enums.TypeTransaction;
import com.c823.consorcio.mapper.TransactionMap;
import com.c823.consorcio.repository.ITransactionRepository;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.repository.IaccountRepository;
import com.c823.consorcio.service.IAccountService;
import com.c823.consorcio.service.ITransactionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  private IaccountRepository iaccountRepository;
  @Autowired
  private TransactionMap transactionMap;
  @Autowired
  private IAccountService iAccountService;
  @Autowired
  private ITransactionRepository iTransactionRepository;




  @Override
  public TransactionDto sendInvoice(BillPaymentDto billPaymentDto) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = userRepository.findByEmail(email);
    AccountEntity account = iaccountRepository.findByUser(user);
    AccountEntity receive = iaccountRepository.findById(
        billPaymentDto.getDestinationAccountId()).orElseThrow(
            ()-> new ParamNotFound("The destination account do not exist"));
    if (user == null || receive == null){
      throw new ParamNotFound("Invalid Operation");
    }
    if(billPaymentDto.getAmount() <= 0){
      throw new ParamNotFound("Ammount must be greater than 0 (zero)");
    }

    TransactionDto send = new TransactionDto();
    send.setAmount(billPaymentDto.getAmount());
    send.setDescription(billPaymentDto.getDescription());
    send.setAccountId(account.getAccountId());
    send.setDestinationAccountId(receive.getAccountId());
    send.setType(TypeTransaction.BILLPAYMENT);
    send.setTransactionDate(new Date());
    TransactionDto transactionDto = createTransaction(send);

    TransactionDto receiver = new TransactionDto();
    receiver.setAmount(billPaymentDto.getAmount());
    receiver.setDescription(billPaymentDto.getDescription());
    receiver.setAccountId(receive.getAccountId());
    receiver.setType(TypeTransaction.PAYMENT);
    receiver.setTransactionDate(new Date());
    createTransaction(receiver);

    return transactionDto;


  }

  @Override
  public TransactionDto createTransaction(TransactionDto transactionDto) {
    if(transactionDto.getAmount() <= 0){
      throw new ParamNotFound("The amount most be greater than 0 (zero)");
    }else {
      TransactionEntity transactionEntity = transactionMap.transactionDto2Entity(transactionDto);
      AccountEntity accountEntity = iaccountRepository.findByAccountId(transactionDto.getAccountId());
      transactionEntity.setAmount(transactionDto.getAmount());
      transactionEntity.setType(transactionDto.getType());
      transactionEntity.setAccountId(accountEntity);
      transactionEntity.setUserEntity(accountEntity.getUser());
      transactionEntity.setDescription(transactionDto.getDescription());
      transactionEntity.setTransactionDate(new Date());
      this.iAccountService.updateBalance(
          transactionDto.getAccountId(),transactionDto.getAmount(),transactionDto.getType());
      this.iTransactionRepository.save(transactionEntity);
      transactionDto.setTransactionId(transactionEntity.getTransactionId());
      return transactionDto;
    }
  }

  @Override
  public TransactionDto sendPayment(BillPaymentDto billPaymentDto) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = userRepository.findByEmail(email);
    AccountEntity account = iaccountRepository.findByUser(user);
    AccountEntity receive = iaccountRepository.findById(
        billPaymentDto.getDestinationAccountId()).orElseThrow(
        ()-> new ParamNotFound("The destination account do not exist"));
    if (user == null || receive == null){
      throw new ParamNotFound("Invalid Operation");
    }
    if(billPaymentDto.getAmount() <= 0){
      throw new ParamNotFound("Ammount must be greater than 0 (zero)");
    }

    TransactionDto send = new TransactionDto();
    send.setAmount(billPaymentDto.getAmount());
    send.setDescription(billPaymentDto.getDescription());
    send.setAccountId(account.getAccountId());
    send.setDestinationAccountId(receive.getAccountId());
    send.setType(TypeTransaction.SENDPAYMENT);
    send.setTransactionDate(new Date());
    TransactionDto transactionDto = createTransaction(send);

    TransactionDto receiver = new TransactionDto();
    receiver.setAmount(billPaymentDto.getAmount());
    receiver.setDescription(billPaymentDto.getDescription());
    receiver.setAccountId(receive.getAccountId());
    receiver.setType(TypeTransaction.INCOME);
    receiver.setTransactionDate(new Date());
    createTransaction(receiver);

    return transactionDto;

  }
}
