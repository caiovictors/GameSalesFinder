package com.inatel.gamesalesfinder.services;

import com.inatel.gamesalesfinder.forms.SignUpForm;

public class PasswordMatchService {

  public boolean isPasswordMatch(SignUpForm signUpForm) {
    return signUpForm.getPassword().equals(signUpForm.getPasswordConfirmation());
  }
}
