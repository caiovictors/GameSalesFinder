package com.inatel.gamesalesfinder.services;

import java.util.ArrayList;
import java.util.List;

import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.models.Store;

public class FindBestPriceService {
  public List<Store> findBestPrice(List<Game> games) {
    Double bestPrice = Double.parseDouble(games.get(0).getSalePrice());

    FindAvailableStoresService availableStores = new FindAvailableStoresService();

    @SuppressWarnings("unchecked")
    List<Store> stores = (List<Store>) availableStores.findStore().getBody();
    List<Store> gameInSaleStores = new ArrayList<Store>();

    MatchStoreService matchStoreService = new MatchStoreService();

    for (Game game : games) {
      Store store = matchStoreService.matchStore(game, stores);

      if (store.getIsActive() && Double.parseDouble(game.getSalePrice()) <= bestPrice) {
        gameInSaleStores.add(store);
      } else
        break;
    }

    return gameInSaleStores;
  }
}
