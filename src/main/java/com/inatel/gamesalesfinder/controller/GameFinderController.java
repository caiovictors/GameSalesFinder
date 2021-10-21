package com.inatel.gamesalesfinder.controller;

import com.inatel.gamesalesfinder.services.FindGameService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameFinderController {

  @GetMapping("/title={title}")
  public ResponseEntity<?> getGame(@PathVariable String title) {
    return new FindGameService().findGame(title);
  }
}
