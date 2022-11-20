package com.c823.consorcio.auth.service;

import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.exception.RepeatedUsername;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return null;
  }

  public ResponseUserDto save(ResponseUserDto userDto) throws RepeatedUsername {
    if (IApartmentRepository.findByApartmentNumber(userDto.getApartmentNumber()) != null){
      throw new RepeatedUsername("Repeted Department Number");
    }
    return null;
  }

}
