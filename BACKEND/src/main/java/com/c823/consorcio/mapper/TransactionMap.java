package com.c823.consorcio.mapper;

import com.c823.consorcio.dto.TransactionDto;
import com.c823.consorcio.entity.TransactionEntity;
import com.c823.consorcio.repository.IaccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMap {

  @Autowired
  private IaccountRepository iaccountRepository;

  public TransactionEntity transactionDto2Entity(TransactionDto transactionDto) {
    TransactionEntity entity = new TransactionEntity();
    entity.setTransactionId(transactionDto.getTransactionId());
    entity.setType(transactionDto.getType());
    entity.setAmount(transactionDto.getAmount());
    entity.setTransactionDate(transactionDto.getTransactionDate());
    entity.setAccountId(this.iaccountRepository.findByAccountId(transactionDto.getAccountId()));

    return entity;

  }

  public List<TransactionDto> entityList2BasicDtoList(List<TransactionEntity> transactions) {

  }
}
