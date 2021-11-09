package com.inatel.gamesalesfinder.adapters;

import java.util.List;

import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.models.Store;
import com.inatel.gamesalesfinder.variables.SecurityConstants;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StoresAdapter {
  public ResponseEntity<?> getStores() {
    try {
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<List<Store>> response = restTemplate.exchange(SecurityConstants.STORE_URL, HttpMethod.GET, null,
          new ParameterizedTypeReference<List<Store>>() {
          });
      return response;

    } catch (Exception e) {
      Exceptions exception = new Exceptions("Service Unavailable", 503, "External Api is unavailable",
          "CheapShark Api not responding");
      return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception);
    }
  }
}
