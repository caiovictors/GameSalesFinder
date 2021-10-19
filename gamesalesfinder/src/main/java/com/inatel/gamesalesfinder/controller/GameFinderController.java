package com.inatel.gamesalesfinder.controller;

import java.util.List;

import com.inatel.gamesalesfinder.models.BestPriceGame;
import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.models.Store;
import com.inatel.gamesalesfinder.services.FindBestPriceService;
import com.inatel.gamesalesfinder.variables.SecurityConstants;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/game")
public class GameFinderController {

  @GetMapping("/title={title}")
  public ResponseEntity<BestPriceGame> getGame(@PathVariable String title) {
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<List<Game>> response = restTemplate.exchange(SecurityConstants.BASE_URL + title, HttpMethod.GET,
        null, new ParameterizedTypeReference<List<Game>>() {
        });
    List<Game> games = response.getBody();

    FindBestPriceService findBestPriceService = new FindBestPriceService();
    List<Store> stores = findBestPriceService.findBestPrice(games);

    BestPriceGame bestPriceGame = new BestPriceGame(games.get(0), stores);

    System.out.println(bestPriceGame.getGame().getTitle());
    System.out.println(bestPriceGame.getGame().getSalePrice());
    System.out.println(bestPriceGame.getStores());

    return ResponseEntity.ok(bestPriceGame);
  }
}
