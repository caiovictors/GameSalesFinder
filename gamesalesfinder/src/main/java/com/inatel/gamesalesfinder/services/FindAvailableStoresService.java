package com.inatel.gamesalesfinder.services;

import java.util.ArrayList;
import java.util.List;

import com.inatel.gamesalesfinder.adapter.StoresAdapter;
import com.inatel.gamesalesfinder.models.Store;

public class FindAvailableStoresService {
  public List<Store> findStore() {
    StoresAdapter storesAdapter = new StoresAdapter();

    List<Store> stores = storesAdapter.getStores();
    List<Store> availableStores = new ArrayList<Store>();

    stores.forEach(store -> {
      if (store.getIsActive())
        availableStores.add(store);
    });
    return availableStores;
  }
}
