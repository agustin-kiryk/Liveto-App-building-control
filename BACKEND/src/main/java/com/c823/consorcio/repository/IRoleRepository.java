package com.c823.consorcio.repository;

import com.c823.consorcio.entity.RoleEntity;
import com.c823.consorcio.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

  RoleEntity findByRoleName(RoleName roleName);


}
