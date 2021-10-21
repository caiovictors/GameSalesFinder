package com.inatel.gamesalesfinder.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestPriceGame {
  private Game game;
  private List<Store> stores;
}
