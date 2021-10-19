package com.inatel.gamesalesfinder.adapter;

import java.util.List;

import com.inatel.gamesalesfinder.models.Store;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StoresAdapter {
  private String STORE_URL = "https://www.cheapshark.com/api/1.0/stores";

  @Cacheable("Stores")
  public List<Store> getStores() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Store>> response = restTemplate.exchange(STORE_URL, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Store>>() {
        });
    List<Store> stores = response.getBody();

    return stores;
  }
}
