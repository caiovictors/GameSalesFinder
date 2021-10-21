package com.inatel.gamesalesfinder.dto;

import java.util.HashMap;
import java.util.Map;

import com.inatel.gamesalesfinder.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistDTO {
  private String gameName;
  private Map<String, String> user = new HashMap<String, String>();

  public WishlistDTO(String gameName, User user) {
    this.gameName = gameName;
    this.user.put("id", user.getId());
    this.user.put("name", user.getName());
    this.user.put("email", user.getEmail());
  }
}
