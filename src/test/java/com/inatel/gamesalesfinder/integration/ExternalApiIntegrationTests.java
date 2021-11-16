package com.inatel.gamesalesfinder.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inatel.gamesalesfinder.services.FindAvailableStoresService;
import com.inatel.gamesalesfinder.services.FindGameService;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import org.junit.jupiter.api.Test;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integration.properties")
public class ExternalApiIntegrationTests {
  private FindGameService findGameService;
  private FindAvailableStoresService findAvailableStoresService;

  public ExternalApiIntegrationTests() {
    this.findGameService = new FindGameService();
    this.findAvailableStoresService = new FindAvailableStoresService();
  }

  @Test
  public void shouldConnectAndFindGame() {
    ResponseEntity<?> response = findGameService.findGame("god of war");
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void shouldConnectAndNotFindGame() {
    ResponseEntity<?> response = findGameService.findGame("god of wa");
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  public void couldNotConnectToExternalApi() {
    ResponseEntity<?> response = findGameService.findGame("god of war");
    assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
  }

  @Test
  public void shouldConnectAndFindStores() {
    ResponseEntity<?> response = findAvailableStoresService.findStore();
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void couldNotFindStores() {
    ResponseEntity<?> response = findAvailableStoresService.findStore();
    assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
  }

}
