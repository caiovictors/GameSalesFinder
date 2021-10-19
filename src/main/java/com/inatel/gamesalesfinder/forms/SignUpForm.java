package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpForm {
  @NotEmpty
  @NotBlank(message = "name is required")
  @Size(min = 6, max = 15, message = "name length must be between 6 and 15")
  private String name;

  @NotEmpty
  @NotBlank(message = "email is required")
  @Email(message = "email is invalid")
  private String email;

  @NotBlank
  @NotEmpty(message = "password is required")
  private String password;

  @NotBlank
  @NotEmpty(message = "repeat password is required")
  private String passwordConfirmation;
}
