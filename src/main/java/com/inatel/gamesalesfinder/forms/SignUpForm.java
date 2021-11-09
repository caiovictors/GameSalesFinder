package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpForm {
  @NotEmpty(message = "name is required")
  @Size(min = 6, max = 15, message = "name length must be between 6 and 15")
  private String name;

  @NotEmpty(message = "email is required")
  @Email(message = "email is invalid")
  private String email;

  @NotEmpty(message = "password is required")
  @Size(min = 8, max = 15, message = "password length must be between 8 and 15")
  private String password;
}
