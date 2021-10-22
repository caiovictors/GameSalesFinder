package com.inatel.gamesalesfinder.services;

import java.util.List;
import java.util.Optional;

import com.inatel.gamesalesfinder.dto.WishlistDTO;
import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.forms.WishlistForm;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddGameToWishlistService {
  boolean gameIsPresent = false;

  public ResponseEntity<?> execute(WishlistRepository wishlistRepository, UserRepository userRepository,
      WishlistForm wishlistForm) {
    String gameName = wishlistForm.getGameName();
    GetUserByTokenService userByToken = new GetUserByTokenService();
    Optional<User> user = userByToken.run(userRepository);

    ResponseEntity<?> foundGame = new FindGameService().findGame(gameName);
    if (foundGame.getStatusCode() != HttpStatus.OK) {
      return foundGame;
    }

    List<Optional<Wishlist>> wishlistList = wishlistRepository.findByUserId(user.get().getId());

    wishlistList.forEach(game -> {
      if (game.get().getGameName().equals(gameName)) {
        gameIsPresent = true;
      }
    });

    if (gameIsPresent) {
      Exceptions exception = new Exceptions("Confict", 409, "Game already on wishlist",
          "The game: " + gameName + " already exists on wishlist");
      return ResponseEntity.status(HttpStatus.CONFLICT).body(exception);
    }

    wishlistRepository.save(new Wishlist(gameName, user.get()));
    WishlistDTO wishlistDTO = new WishlistDTO(gameName, user.get());

    return ResponseEntity.status(HttpStatus.CREATED).body(wishlistDTO);
  }
}
