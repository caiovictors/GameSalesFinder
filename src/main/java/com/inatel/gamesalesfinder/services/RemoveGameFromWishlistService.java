package com.inatel.gamesalesfinder.services;

import java.util.Optional;

import com.inatel.gamesalesfinder.errors.Exceptions;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RemoveGameFromWishlistService {
  public ResponseEntity<?> delete(WishlistRepository wishlistRepository, UserRepository userRepository, Long id) {
    GetUserByTokenService userByToken = new GetUserByTokenService();
    Optional<User> user = userByToken.run(userRepository);
    Optional<Wishlist> wishlist = wishlistRepository.findById(id);

    // Check if game is present on wishlist and if wishlist belongs to the user
    // authenticated
    if (wishlist.isPresent() && (wishlist.get().getUser().getId() == user.get().getId())) {
      wishlistRepository.delete(wishlist.get());

      return ResponseEntity.status(HttpStatus.OK).body(wishlist.get());
    }

    Exceptions exception = new Exceptions("Not Found", 404, "Wishlist id not found",
        "The id: " + id + " doesn't exists on your wishlist");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
  }
}
