package com.c823.consorcio.repository;
import com.c823.consorcio.entity.ApartmentEntity;
import com.c823.consorcio.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApartmentRepository extends JpaRepository<ApartmentEntity, Long> {

  ApartmentEntity findByApartmentNumber (Long apartmentNumber);


  List<ApartmentEntity> findAllByUser(UserEntity user);

}
