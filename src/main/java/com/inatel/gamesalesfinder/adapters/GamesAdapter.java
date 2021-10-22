package com.inatel.gamesalesfinder.adapters;

import java.util.List;

import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.variables.SecurityConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GamesAdapter {
  public ResponseEntity<?> getGames(String title) {
    RestTemplate restTemplate = new RestTemplate();

    try {
      ResponseEntity<List<Game>> response = restTemplate.exchange(SecurityConstants.BASE_URL + title, HttpMethod.GET,
          null, new ParameterizedTypeReference<List<Game>>() {
          });
      return response;
    } catch (Exception e) {
      Exceptions exception = new Exceptions("Service Unavailable", 503, "External Api is unavailable",
          "CheapShark Api not responding");
      return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception);
    }
  }
}
