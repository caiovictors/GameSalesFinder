package com.inatel.gamesalesfinder.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BestPriceGame {
  private Game game;
  private List<Store> stores;
}
