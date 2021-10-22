package com.inatel.gamesalesfinder.controller;

import javax.transaction.Transactional;

import com.inatel.gamesalesfinder.forms.WishlistForm;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/wishlist")
@Api(value = "Wishlist", description = "Wishlist your games", tags = { "Wishlist" })
public class WishlistController {
  private WishlistRepository wishlistRepository;
  private UserRepository userRepository;

  @GetMapping()
  @ApiOperation(value = "Get user wishlist", tags = { "Wishlist" })
  public ResponseEntity<?> getUserWishlist(@RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "6") int size) {

    Pageable paging = PageRequest.of(page, size);

    return new GetGameFromWishlistService().execute(userRepository, wishlistRepository, paging);
  }

  @PostMapping
  @Transactional
  @ApiOperation(value = "Add game to wishlist", tags = { "Wishlist" })
  public ResponseEntity<?> addGameToWishlist(@RequestBody WishlistForm wishlistForm) {
    return new AddGameToWishlistService().execute(wishlistRepository, userRepository, wishlistForm);
  }

  @DeleteMapping("/{id}")
  @Transactional
  @ApiOperation(value = "Delete from wishlist", tags = { "Wishlist" })
  public ResponseEntity<?> deleteGameFromWishlist(@PathVariable(value = "id") Long id) {
    return new RemoveGameFromWishlistService().delete(wishlistRepository, userRepository, id);
  }
}
