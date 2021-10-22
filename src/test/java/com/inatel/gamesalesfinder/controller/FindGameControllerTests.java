package com.inatel.gamesalesfinder.controller;

import static org.mockito.Mockito.when;

import com.inatel.gamesalesfinder.services.FindGameService;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
// @RunWith(MockitoJUnitRunner.class)
public class FindGameControllerTests {
  private Authentication authentication;
  private SecurityContext securityContext;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    // Authentication
    authentication = Mockito.mock(Authentication.class);
    securityContext = Mockito.mock(SecurityContext.class);
    when(securityContext.getAuthentication()).thenReturn(authentication);
    SecurityContextHolder.setContext(securityContext);
  }

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
