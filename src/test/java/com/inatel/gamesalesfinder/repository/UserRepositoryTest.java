package com.inatel.gamesalesfinder.repository;

import java.util.Optional;

import com.inatel.gamesalesfinder.models.User;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
  @Autowired
  private UserRepository userRepository;

  @Test
  public void shouldFindByEmail() {
    String email = "caio@gmail.com";
    User user = userRepository.findByEmail(email).get();
    Assert.assertEquals(user.getEmail(), email);
  }

  @Test
  public void shouldNotFindByEmail() {
    String email = "sarah@outlook.com";
    Optional<User> user = userRepository.findByEmail(email);
    Assert.assertTrue(user.isEmpty());
  }
}
