package com.inatel.gamesalesfinder.dto;

import java.util.HashMap;
import java.util.Map;

import com.inatel.gamesalesfinder.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDTO {
  private Map<String, String> user = new HashMap<String, String>();

  public SignUpDTO(User user) {
    this.user.put("id", user.getId());
    this.user.put("name", user.getName());
    this.user.put("email", user.getEmail());
  }
}