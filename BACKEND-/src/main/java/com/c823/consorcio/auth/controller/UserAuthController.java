package com.c823.consorcio.auth.controller;

import com.c823.consorcio.auth.dto.AuthenticationRequest;
import com.c823.consorcio.auth.dto.AuthenticationResponse;
import com.c823.consorcio.auth.dto.ResponseUserDto;
import com.c823.consorcio.auth.dto.UserAuthDto;
import com.c823.consorcio.auth.service.JwtUtils;
import com.c823.consorcio.auth.service.UserDetailsCustomService;
import com.c823.consorcio.service.IUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")


public class UserAuthController {

  private UserDetailsCustomService userDetailsServices;
  private AuthenticationManager authenticationManager;
  private JwtUtils jwtTokenUtils;

  @Autowired
  public UserAuthController(UserDetailsCustomService userDetailsServices,
      AuthenticationManager authenticationManager, JwtUtils jwtTokenUtils,
      IUserService iUserService) {
    this.userDetailsServices = userDetailsServices;
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtils = jwtTokenUtils;
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseUserDto> signUp(@Valid @RequestBody ResponseUserDto user) {
    ResponseUserDto userRegister = this.userDetailsServices.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(userRegister);
  }

  @PostMapping("/registerAdmin")
  public ResponseEntity<AuthenticationResponse> signUpAdmin(@Valid @RequestBody UserAuthDto user) {
    this.userDetailsServices.saveAdmin(user);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }


  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> signIn(
      @RequestBody AuthenticationRequest authenticationRequest) {

    UserDetails userDetails;

    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
            authenticationRequest.getPassword())
    );
    userDetails = (UserDetails) auth.getPrincipal();

    final String jwt = jwtTokenUtils.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }


  }

