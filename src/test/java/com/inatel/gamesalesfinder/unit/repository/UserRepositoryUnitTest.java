package com.inatel.gamesalesfinder.unit.repository;

import java.util.Optional;

import com.inatel.gamesalesfinder.generator.ObjectGenerator;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.repository.UserRepository;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-h2-tests.properties")
public class UserRepositoryUnitTest {
  @Autowired
  private UserRepository userRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    userRepository = Mockito.mock(UserRepository.class);
  }

  @Test
  public void shouldFindByEmail() {
    User user = new ObjectGenerator().generateUser();

    String email = "caioteste@gmail.com";

    Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
    User user_test = userRepository.findByEmail(email).get();
    Assert.assertEquals(user_test.getEmail(), email);
  }

  @Test
  public void shouldNotFindByEmail() {
    String email = "sarah@outlook.com";
    Optional<User> user = userRepository.findByEmail(email);
    Assert.assertTrue(user.isEmpty());
  }
}
