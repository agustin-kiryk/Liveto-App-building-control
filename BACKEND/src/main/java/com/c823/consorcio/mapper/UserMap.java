package com.c823.consorcio.mapper;

import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMap {
  @Autowired
  AccountMap accountMap;


  public UserEntity userAuthDto2Entity(ResponseUserDto userDto) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    UserEntity userEntity = new UserEntity();
    userEntity.setFirstName(userDto.getFirstName());
    userEntity.setLastName(userDto.getLastName());
    userEntity.setEmail(userDto.getEmail());
    userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    userEntity.setCreationDate(userDto.getCreationDate());

    return userEntity;

  }

  public ResponseUserDto userAuthEntity2Dto(UserEntity entitySaved) {
    ResponseUserDto dto = new ResponseUserDto();
    dto.setId(entitySaved.getUserId());
    dto.setFirstName(entitySaved.getFirstName());
    dto.setLastName(entitySaved.getLastName());
    dto.setEmail(entitySaved.getEmail());
    dto.setCreationDate(entitySaved.getCreationDate());
    dto.setAccounts(this.accountMap.accountEntityList2DtoList(entitySaved.getAccounts()));

    return dto;
  }
}
