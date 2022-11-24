package com.c823.consorcio.auth.dto;

import com.c823.consorcio.dto.AccountDto;
import com.c823.consorcio.enums.RoleName;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResponseUserDto {
  private Long id;
  @NotNull
  private String firstName;
  private String lastName;
  @NotEmpty
  private String email;
  private String password;
  private RoleName role;
  private List<AccountDto> accounts;
  private Date creationDate;
  private Long apartmentNumber;
  private String jwt;


}
