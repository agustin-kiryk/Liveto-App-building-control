package com.c823.consorcio.repository;

import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.TransactionEntity;
import com.c823.consorcio.enums.TypeTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long > {

  List<TransactionEntity> findAllByAccountIdAndType(AccountEntity account, TypeTransaction type);




}
