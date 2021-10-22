package com.inatel.gamesalesfinder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inatel.gamesalesfinder.dto.WishlistGameDTO;
import com.inatel.gamesalesfinder.models.BestPriceGame;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetGameFromWishlistService {
  ResponseEntity<?> apiNotWorking = null;

  public ResponseEntity<?> execute(UserRepository userRepository, WishlistRepository wishlistRepository,
      Pageable paging) {
    GetUserByTokenService addGameToWishlistByTokenService = new GetUserByTokenService();
    Optional<User> user = addGameToWishlistByTokenService.run(userRepository);

    Page<Wishlist> wishlistPage = wishlistRepository.findByUserId(user.get().getId(), paging);

    List<WishlistGameDTO> wishlistGame = new ArrayList<>();

    wishlistPage.getContent().forEach(game -> {
      ResponseEntity<?> foundGame = new FindGameService().findGame(game.getGameName());

      if (foundGame.getStatusCode() != HttpStatus.OK) {
        apiNotWorking = ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(foundGame.getBody());
      } else {
        BestPriceGame bestPriceGame = (BestPriceGame) foundGame.getBody();
        wishlistGame.add(new WishlistGameDTO(game.getId(), bestPriceGame.getGame().getTitle(),
            bestPriceGame.getGame().getSalePrice(), bestPriceGame.getStores()));
      }
    });

    if (apiNotWorking != null) {
      return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(apiNotWorking.getBody());
    }

    return ResponseEntity.ok(wishlistGame);
  }
}
