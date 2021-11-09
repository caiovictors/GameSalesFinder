package com.inatel.gamesalesfinder.unit.controller;

import com.inatel.gamesalesfinder.services.FindGameService;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-h2-tests.properties")
public class FindGameControllerUnitTests {

  @Test
  public void shouldFindGame() {
    String title = "Sunset Overdrive";
    FindGameService findGameService = new FindGameService();
    ResponseEntity<?> response = findGameService.findGame(title);

    Assert.assertEquals(200, response.getStatusCode().value());
  }

  @Test
  public void shouldNotFindGameMistped() {
    String title = "Sunset Overdriv";
    FindGameService findGameService = new FindGameService();
    ResponseEntity<?> response = findGameService.findGame(title);

    Assert.assertEquals(404, response.getStatusCode().value());
  }

  @Test
  public void shouldNotFindNullGame() {
    String title = "";
    FindGameService findGameService = new FindGameService();
    ResponseEntity<?> response = findGameService.findGame(title);

    Assert.assertEquals(404, response.getStatusCode().value());
  }
}
