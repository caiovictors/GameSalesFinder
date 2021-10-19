package com.inatel.gamesalesfinder.services;

import java.util.List;

import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.models.Store;

public class MatchStoreService {
  public Store matchStore(Game game, List<Store> stores) {
    String storeId = game.getStoreID();

    for (Store store : stores) {
      if (store.getStoreID().equals(storeId)) {
        return store;
      }
    }
    return null;
  }
}
