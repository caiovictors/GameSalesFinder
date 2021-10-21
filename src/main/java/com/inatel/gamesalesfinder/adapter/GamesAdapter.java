package com.inatel.gamesalesfinder.adapter;

import java.util.List;

import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.variables.SecurityConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GamesAdapter {
  public List<Game> getGames(String title) {
    RestTemplate restTemplate = new RestTemplate();

    try {
      ResponseEntity<List<Game>> response = restTemplate.exchange(SecurityConstants.BASE_URL + title, HttpMethod.GET,
          null, new ParameterizedTypeReference<List<Game>>() {
          });
      return response.getBody();
    } catch (Exception e) {
      ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      log.info("Error on connection with external api");
    }

    return null;
  }
}
