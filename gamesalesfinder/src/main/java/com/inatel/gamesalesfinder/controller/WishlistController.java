package com.inatel.gamesalesfinder.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
  private WishlistRepository wishlistRepository;
  private UserRepository userRepository;
  private Integer wishlistCounter = 0;

  public WishlistController(WishlistRepository wishlistRepository, UserRepository userRepository) {
    this.wishlistRepository = wishlistRepository;
    this.userRepository = userRepository;
  }

  @GetMapping()
  @Cacheable("wishlist")
  public List<Wishlist> getWishlists() {
    return wishlistRepository.findAll();
  }

  @GetMapping("/{id}")
  @Cacheable("wishlist")
  public List<Optional<Wishlist>> getUserWishlist(@PathVariable(value = "id") String id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isPresent()) {
      List<Optional<Wishlist>> wishlist = wishlistRepository.findByUserId(user.get().getId());
      return wishlist;
    } else {
      return null;
    }
  }

  @PostMapping
  @Transactional
  @CacheEvict(value = "wishlist", allEntries = true)
  public Wishlist addGameToWishlist(@RequestBody Wishlist wishlist) {
    Optional<User> user = userRepository.findById(wishlist.getUser().getId());

    if (user.isPresent()) {
      wishlist.setUser(user.get());
      wishlistCounter = wishlistCounter + 1;
    } else {
      return null;
    }
    return wishlistRepository.save(new Wishlist(wishlistCounter, wishlist.getGameName(), wishlist.getUser()));
  }

  @DeleteMapping("/{id}")
  @Transactional
  @CacheEvict(value = "wishlist", allEntries = true)
  public void deleteGameFromWishlist(@PathVariable(value = "id") Long id) {
    Optional<Wishlist> wishlist = wishlistRepository.findById(id);

    wishlistRepository.delete(wishlist.get());
  }
}
