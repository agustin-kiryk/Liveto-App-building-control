package com.c823.consorcio.repository;

import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IaccountRepository extends JpaRepository<AccountEntity, Long> {

  List<AccountEntity> findAllByUser(UserEntity user);
  AccountEntity findByAccountId(Long accountId);

  AccountEntity findByUser(UserEntity user);
}
