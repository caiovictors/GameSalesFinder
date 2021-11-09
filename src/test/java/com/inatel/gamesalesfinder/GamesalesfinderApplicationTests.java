package com.inatel.gamesalesfinder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-h2-tests.properties")
public class GameSalesFinderApplicationTests {
  @Test
  public void contextLoads() {
  }
}
