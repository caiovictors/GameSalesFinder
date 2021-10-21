package com.inatel.gamesalesfinder.services;

import java.util.List;

import com.inatel.gamesalesfinder.adapter.GamesAdapter;
import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.models.BestPriceGame;
import com.inatel.gamesalesfinder.models.Game;
import com.inatel.gamesalesfinder.models.Store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FindGameService {
  public ResponseEntity<?> findGame(String title) {
    GamesAdapter gamesAdapter = new GamesAdapter();
    List<Game> availableGames = gamesAdapter.getGames(title);

    if (availableGames == null || availableGames.isEmpty() || title == "") {
      Exceptions exception = new Exceptions("Not Found", 404, "Game not found", "Game title not found or mistyped");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    FindBestPriceService findBestPriceService = new FindBestPriceService();
    List<Store> stores = findBestPriceService.findBestPrice(availableGames);

    BestPriceGame bestPriceGame = new BestPriceGame(availableGames.get(0), stores);

    return ResponseEntity.ok(bestPriceGame);
  }
}
