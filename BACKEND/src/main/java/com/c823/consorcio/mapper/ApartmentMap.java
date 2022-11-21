package com.c823.consorcio.mapper;

import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.entity.ApartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class ApartmentMap {

  public ApartmentEntity apartmentDTO2Entity(ResponseUserDto userDto) {
    ApartmentEntity apartmentEntity = new ApartmentEntity();
    apartmentEntity.setApartmentNumber(userDto.getApartmentNumber());
    return apartmentEntity;
  }
}
