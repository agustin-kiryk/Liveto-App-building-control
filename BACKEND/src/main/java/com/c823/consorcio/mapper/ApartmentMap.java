package com.c823.consorcio.mapper;

import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.dto.ApartmentDto;
import com.c823.consorcio.entity.ApartmentEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ApartmentMap {

  public ApartmentEntity apartmentDTO2Entity(ResponseUserDto userDto) {
    ApartmentEntity apartmentEntity = new ApartmentEntity();
    apartmentEntity.setApartmentNumber(userDto.getApartmentNumber());
    apartmentEntity.setFloor(userDto.getFloor());
    return apartmentEntity;
  }

  public ApartmentDto apartmentEntity2Dto(ApartmentEntity entity){
    ApartmentDto dto = new ApartmentDto();
    dto.setApartmentId(entity.getApartmentId());
    dto.setApartmentNumber(entity.getApartmentNumber());
    dto.setFloor(entity.getFloor());
    dto.setUser(entity.getUser());
    dto.setAccount(entity.getAccount());

    return dto;
  }


  public List<ApartmentDto> apartmentEntityList2DtoList(List<ApartmentEntity> apartments) {

    List<ApartmentDto> apartmentDtos = new ArrayList<>();

    ApartmentDto dto;

    for (ApartmentEntity apartment: apartments){
      dto = new ApartmentDto();
      dto.setApartmentId(apartment.getApartmentId());
      dto.setApartmentNumber(apartment.getApartmentNumber());
      dto.setFloor(apartment.getFloor());
      dto.setAccount(apartment.getAccount());
      apartmentDtos.add(dto);

    }
    return apartmentDtos;


  }
}
