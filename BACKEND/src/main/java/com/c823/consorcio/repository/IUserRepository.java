package com.c823.consorcio.repository;

import com.c823.consorcio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);



}
