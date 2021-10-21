package com.inatel.gamesalesfinder.adapter;

import java.util.List;

import com.inatel.gamesalesfinder.models.Store;
import com.inatel.gamesalesfinder.variables.SecurityConstants;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StoresAdapter {
  public List<Store> getStores() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Store>> response = restTemplate.exchange(SecurityConstants.STORE_URL, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Store>>() {
        });
    List<Store> stores = response.getBody();

    return stores;
  }
}
