package com.inatel.gamesalesfinder.models;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class UserDetailsImpl extends org.springframework.security.core.userdetails.User {
  private User user;

  public UserDetailsImpl(User user) {
    super(user.getEmail(), user.getPassword(), authorities(user));
    this.user = user;
  }

  private static Collection<? extends GrantedAuthority> authorities(User user) {
    return new ArrayList<>();
  }
}