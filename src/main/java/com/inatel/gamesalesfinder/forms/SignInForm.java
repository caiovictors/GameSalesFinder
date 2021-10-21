package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignInForm {
  @NotEmpty
  @NotBlank(message = "email is required")
  @Email
  private String email;

  @NotEmpty
  @NotBlank(message = "password is required")
  private String password;
}
