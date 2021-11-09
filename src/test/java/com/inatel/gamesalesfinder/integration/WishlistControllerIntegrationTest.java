// package com.inatel.gamesalesfinder.integration;

// import com.inatel.gamesalesfinder.dto.SignInDTO;
// import com.inatel.gamesalesfinder.dto.SignUpDTO;
// import com.inatel.gamesalesfinder.dto.WishlistDTO;
// import com.inatel.gamesalesfinder.forms.SignInForm;
// import com.inatel.gamesalesfinder.forms.SignUpForm;
// import com.inatel.gamesalesfinder.forms.WishlistForm;
// import com.inatel.gamesalesfinder.generator.ObjectGenerator;

// import org.assertj.core.api.Assertions;
// import org.junit.Test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.web.server.LocalServerPort;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.TestPropertySource;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource(locations = "classpath:application-test.properties")
// public class WishlistControllerIntegrationTest {
// @Autowired
// private TestRestTemplate testRestTemplate;

// @LocalServerPort
// private int port;

// private SignInForm signInForm;
// private HttpHeaders headers = new HttpHeaders();
// private ObjectGenerator generator;

// @BeforeEach
// public void setUp() {
// generator = new ObjectGenerator();
// SignUpForm signUpForm = generator.generateSignUpForm();
// testRestTemplate.postForEntity("/auth/signup", signUpForm, SignUpDTO.class);
// signInForm = generator.generateSignInForm();
// ResponseEntity<SignInDTO> signInDTO =
// testRestTemplate.postForEntity("/auth/signin", signInForm, SignInDTO.class);
// String token = signInDTO.getBody().getToken();
// headers.setBearerAuth(token);
// testRestTemplate.postForEntity("/wishlist", new HttpEntity<>(new
// WishlistForm("Mad Max"), headers),
// WishlistDTO.class);
// }

// @Test
// @DisplayName("Should create add game to wishlist given a valid game name")
// void shouldCreateAFlashCardSuccessfully() {
// HttpEntity<?> gameEntity = new HttpEntity<>(generator.generateWishlistForm(),
// headers);

// ResponseEntity<WishlistDTO> response =
// testRestTemplate.postForEntity("/wishlist", gameEntity, WishlistDTO.class);

// Assertions.assertThat(response.getBody().getGameName()).isEqualTo("Mad Max");
// // Assertions.assertThat(response.getBody().getAnswer()).isEqualTo("3.14");
// }

// }
