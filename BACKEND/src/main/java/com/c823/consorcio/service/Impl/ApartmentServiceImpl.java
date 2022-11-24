package com.c823.consorcio.service.Impl;

import com.c823.consorcio.entity.AccountEntity;
import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.UserEntity;
import com.c823.consorcio.repository.IApartmentRepository;
import com.c823.consorcio.repository.IUserRepository;
import com.c823.consorcio.repository.IaccountRepository;
import com.c823.consorcio.service.IApartmentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl implements IApartmentService {

  @Autowired
  IUserRepository userRepository;
  @Autowired
  IaccountRepository iaccountRepository;
  @Autowired
  IApartmentRepository iApartmentRepository;


  @Override
  public String addApartment(Long apartmentNumber, String email) {
    String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    UserEntity user = this.userRepository.findByEmail(email);
    List<ApartmentEntity> apartments = this.iApartmentRepository.findAllByUser(user);
   /* if (user == null) {
      throw new ParamNotFound("ID invalid");

    }*/
    ApartmentEntity apartment = createApartment(apartmentNumber);
    UserEntity log = this.userRepository.findByEmail(email);
    apartment.setUser(log);
    this.iApartmentRepository.save(apartment);
    log.addApartment(apartment);
    this.userRepository.save(log);
    return HttpStatus.CREATED.getReasonPhrase();


  }

  @Override
  public ApartmentEntity createApartment(Long apartmentNumber) {
    ApartmentEntity apartment = new ApartmentEntity();
    apartment.setApartmentNumber(apartmentNumber);

    return apartment;
  }
}
/*AccountEntity accountEntity = new AccountEntity();
    accountEntity.setCreationDate(new Date());
    accountEntity.setBalance(0.0);
    accountEntity.setUpdateDate(new Date());

    return accountEntity;*/
