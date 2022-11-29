package com.c823.consorcio.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class RepeatedUsername extends AuthenticationException {
  public RepeatedUsername(String error){super((error));}

}
