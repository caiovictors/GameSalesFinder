package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignInForm {
  @NotNull
  @NotEmpty
  @Email
  private String email;

  @NotNull
  @NotEmpty
  private String password;
}
