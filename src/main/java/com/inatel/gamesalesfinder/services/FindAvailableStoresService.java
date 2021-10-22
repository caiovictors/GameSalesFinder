package com.inatel.gamesalesfinder.services;

import java.util.ArrayList;
import java.util.List;

import com.inatel.gamesalesfinder.adapters.StoresAdapter;
import com.inatel.gamesalesfinder.models.Store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FindAvailableStoresService {
  public ResponseEntity<?> findStore() {
    StoresAdapter storesAdapter = new StoresAdapter();

    ResponseEntity<?> findStores = storesAdapter.getStores();

    if (findStores.getStatusCode() != HttpStatus.OK) {
      return findStores;
    }

    @SuppressWarnings("unchecked")
    List<Store> stores = (List<Store>) findStores.getBody();

    List<Store> availableStores = new ArrayList<Store>();

    stores.forEach(store -> {
      if (store.getIsActive())
        availableStores.add(store);
    });

    return new ResponseEntity<>(availableStores, HttpStatus.OK);
  }
}
