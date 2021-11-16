package com.inatel.gamesalesfinder.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integration.properties")
public class DatabaseIntegrationTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private WishlistRepository wishlistRepository;

  @BeforeEach
  public void setUp() {
    String name = "Test User";
    String email = "test@gmail.com";
    String password = "password";
    User user = new User(name, email, password);

    userRepository.save(user);

    String gameName = "Mad Max";
    wishlistRepository.save(new Wishlist(gameName, user));
  }

  @Test
  public void shouldFindUser() {
    Optional<User> user = userRepository.findByEmail("test@gmail.com");
    assertEquals("Test User", user.get().getName());
  }

  @Test
  public void shouldNotFindUser() {
    Optional<User> user = userRepository.findByEmail("testfake@gmail.com");
    assertFalse(user.isPresent());
  }

  @Test
  public void shouldFindWishlistGame() {
    Optional<Wishlist> wishlist = wishlistRepository.findByGameName("Mad Max");
    assertEquals("Mad Max", wishlist.get().getGameName());
  }

  @Test
  public void shouldNotFindWishlistGame() {
    Optional<Wishlist> wishlist = wishlistRepository.findByGameName("Mad Ma");
    assertFalse(wishlist.isPresent());
  }

}
