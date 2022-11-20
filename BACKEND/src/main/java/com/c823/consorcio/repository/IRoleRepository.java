package com.c823.consorcio.repository;

import com.c823.consorcio.entity.RoleEntity;
import com.c823.consorcio.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IRoleRepository extends JpaRepository {

  RoleEntity findByName(RoleName name);



}
