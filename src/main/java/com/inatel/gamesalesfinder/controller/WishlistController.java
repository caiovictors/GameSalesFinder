package com.inatel.gamesalesfinder.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.inatel.gamesalesfinder.dto.WishlistGameDTO;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;
import com.inatel.gamesalesfinder.services.AddGameToWishlistService;
import com.inatel.gamesalesfinder.services.GetGameFromWishlistService;
import com.inatel.gamesalesfinder.services.RemoveGameFromWishlistService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
  private WishlistRepository wishlistRepository;
  private UserRepository userRepository;

  public WishlistController(WishlistRepository wishlistRepository, UserRepository userRepository) {
    this.wishlistRepository = wishlistRepository;
    this.userRepository = userRepository;
  }

  @GetMapping()
  public List<WishlistGameDTO> getUserWishlist(@RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "10") int size) {

    Pageable paging = PageRequest.of(page, size);

    return new GetGameFromWishlistService().execute(userRepository, wishlistRepository, paging);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> addGameToWishlist(@RequestBody Wishlist wishlist) {
    return new AddGameToWishlistService().execute(wishlistRepository, userRepository, wishlist);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> deleteGameFromWishlist(@PathVariable(value = "id") Long id) {
    return new RemoveGameFromWishlistService().delete(wishlistRepository, userRepository, id);
  }
}
