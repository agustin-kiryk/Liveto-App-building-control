package com.c823.consorcio.service.Impl;

import com.c823.consorcio.auth.exception.ParamNotFound;
import com.c823.consorcio.dto.BillPaymentDto;
import com.c823.consorcio.dto.TransactionDto;
import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.TransactionEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.enums.TypeTransaction;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.repository.IaccountRepository;
import com.c823.consorcio.service.ITransactionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class TransactionServiceImpl implements ITransactionService {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  private IaccountRepository iaccountRepository;



  @Override
  public TransactionDto sendInvoice(BillPaymentDto billPaymentDto) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = userRepository.findByEmail(email);
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
    send.setAccountId(billPaymentDto.getDestinationAccountId());
    send.setType(TypeTransaction.PAYMENT);
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
      TransactionEntity transactionEntity =
    }

    return null;
  }
}
