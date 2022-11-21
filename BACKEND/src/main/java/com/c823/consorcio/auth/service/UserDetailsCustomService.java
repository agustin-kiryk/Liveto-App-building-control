package com.c823.consorcio.auth.service;


import com.c823.consorcio.auth.dto.UserAuthDto;


import com.c823.consorcio.auth.exception.ParamNotFound;

import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.RoleEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.exception.RepeatedUsername;
import com.c823.consorcio.enums.RoleName;
import com.c823.consorcio.mapper.ApartmentMap;
import com.c823.consorcio.mapper.UserMap;
import com.c823.consorcio.repository.IApartmentRepository;
import com.c823.consorcio.repository.IRoleRepository;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.service.IAccountService;
import com.c823.consorcio.service.IapartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {

  @Autowired
  IApartmentRepository iApartmentRepository;
  @Autowired
  UserMap userMap;
  @Autowired
  IRoleRepository iRoleRepository;
  @Autowired
  IUserRepository iUserRepository;
  @Autowired
  IAccountService accountService;
  @Autowired
  ApartmentMap apartmentMap;
  @Autowired
  IapartmentService iapartmentService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return null;
  }

  public ResponseUserDto save(ResponseUserDto userDto) throws RepeatedUsername {
    if (iApartmentRepository.findByApartmentNumber(userDto.getApartmentNumber()) != null){
      throw new RepeatedUsername("Repeted Department Number");
    }
    UserEntity entity = this.userMap.userAuthDto2Entity(userDto);


    RoleEntity role = this.iRoleRepository.findByRoleName(RoleName.USER);

    entity.setRole(role);

    UserEntity entitySaved = this.iUserRepository.save(entity);





    ApartmentEntity apartmentEntity = this.apartmentMap.apartmentDTO2Entity(userDto);
    ApartmentEntity apartmentEntitySaved = this.iApartmentRepository.save(apartmentEntity);

    this.accountService.addAccount(apartmentEntitySaved.getApartmentId(),entitySaved.getEmail());
    //this.iapartmentService



    ResponseUserDto responseUserDto = userMap.userAuthEntity2Dto(entitySaved);





    return responseUserDto;
    }



  public void saveAdmin(UserAuthDto user) {
  }
}
