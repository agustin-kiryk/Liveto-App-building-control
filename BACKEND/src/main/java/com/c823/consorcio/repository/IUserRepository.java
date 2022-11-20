package com.c823.consorcio.repository;

import com.c823.consorcio.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findAllByApartmentNumber(Long )

}
