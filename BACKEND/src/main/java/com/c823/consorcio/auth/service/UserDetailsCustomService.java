package com.c823.consorcio.auth.service;
import com.c823.consorcio.auth.dto.UserAuthDto;
import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.auth.exception.ParamNotFound;
import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.RoleEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.exception.RepeatedUsername;
import com.c823.consorcio.enums.RoleName;
import com.c823.consorcio.mapper.AccountMap;
import com.c823.consorcio.mapper.ApartmentMap;
import com.c823.consorcio.mapper.UserMap;
import com.c823.consorcio.repository.IApartmentRepository;
import com.c823.consorcio.repository.IRoleRepository;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.service.IAccountService;
import com.c823.consorcio.service.IApartmentService;
import java.util.List;
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
  IApartmentService iapartmentService;
  @Autowired
  AccountMap accountMap;



  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = iUserRepository.findByEmail(email);
    if (userEntity == null) {
      throw new UsernameNotFoundException("username or password not found");
    }
    return UserDetailsImpl.build(userEntity);
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
    apartmentEntity.setUser(entitySaved);
    apartmentEntity.setFloor(userDto.getFloor());
    ApartmentEntity apartmentEntitySaved = this.iApartmentRepository.save(apartmentEntity);

    this.accountService.addAccount(apartmentEntitySaved,entitySaved.getEmail());

    ResponseUserDto responseUserDto = userMap.userAuthEntity2Dto(entitySaved);
    responseUserDto.setApartmentNumber(apartmentEntity.getApartmentNumber());
    responseUserDto.setFloor(apartmentEntity.getFloor());

    return responseUserDto;
    }

  public void saveAdmin(UserAuthDto user) {
  }
}
