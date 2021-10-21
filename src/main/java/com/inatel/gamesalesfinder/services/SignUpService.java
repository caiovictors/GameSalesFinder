package com.inatel.gamesalesfinder.services;

import java.util.Date;

import com.inatel.gamesalesfinder.dto.SignUpDTO;
import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.forms.SignUpForm;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignUpService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private SignUpForm signUpForm;

  public ResponseEntity<?> execute() {

    boolean emailAlreadyExists = this.userRepository.findByEmail(this.signUpForm.getEmail()).isPresent();

    if (emailAlreadyExists) {
      Exceptions exception = new Exceptions("Confict", 409, "Email already exists", "Email already exists on database",
          new Date());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(exception);
    }

    String encodedPassword = this.passwordEncoder.encode(signUpForm.getPassword());

    User user = userRepository.save(new User(signUpForm.getName(), signUpForm.getEmail(), encodedPassword));
    SignUpDTO signUpDTO = new SignUpDTO(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(signUpDTO);
  }
}
