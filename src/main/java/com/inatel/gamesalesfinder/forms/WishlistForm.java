package com.inatel.gamesalesfinder.forms;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WishlistForm {
  @NotEmpty(message = "game name must not be null")
  private String gameName;
}
