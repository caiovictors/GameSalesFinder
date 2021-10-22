package com.inatel.gamesalesfinder.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.inatel.gamesalesfinder.forms.SignUpForm;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.services.SignUpService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth/signup")
@Api(value = "Sign Up", description = "Create user for API", tags = { "Sign Up" })
public class SignUpController {
  private UserRepository repository;
  private PasswordEncoder passwordEncoder;

  @PostMapping
  @Transactional
  @ApiOperation(value = "Sign Up", tags = { "Sign Up" })
  public ResponseEntity<?> SignUp(@Valid @RequestBody SignUpForm signUpForm) {
    System.out.println("Create user");
    return new SignUpService(repository, passwordEncoder, signUpForm).execute();
  }
}