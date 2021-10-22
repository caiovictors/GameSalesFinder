package com.inatel.gamesalesfinder.controller;

import com.inatel.gamesalesfinder.services.FindGameService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/game")
// @SecurityRequirement(name = "bearerAuth")
@Api(value = "Game Finder", description = "Find game best price by title", tags = { "Game Finder" })
public class GameFinderController {

  @GetMapping("/title={title}")
  @ApiOperation(value = "Get game", tags = { "Game Finder" })
  public ResponseEntity<?> getGame(@PathVariable String title) {
    return new FindGameService().findGame(title);
  }
}
