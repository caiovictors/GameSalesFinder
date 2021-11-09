package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistForm {
  @NotEmpty(message = "game name must not be null")
  private String gameName;
}
