// package com.inatel.gamesalesfinder.unit.controller;

// import static org.mockito.Mockito.when;

// import java.util.Optional;

// import com.inatel.gamesalesfinder.forms.SignUpForm;
// import com.inatel.gamesalesfinder.generator.ObjectGenerator;
// import com.inatel.gamesalesfinder.models.User;
// import com.inatel.gamesalesfinder.repository.UserRepository;
// import com.inatel.gamesalesfinder.services.SignUpService;

// import org.junit.Test;
// import org.junit.jupiter.api.BeforeEach;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.web.client.RestTemplate;

// import junit.framework.Assert;

// @SpringBootTest
// @TestPropertySource(locations = "classpath:application-h2-tests.properties")
// public class SignUpControllerUnitTests {
// @Autowired
// private UserRepository userRepository;

// private PasswordEncoder passwordEncoder;

// private ObjectGenerator generator;

// @BeforeEach
// public void setUp() {
// MockitoAnnotations.openMocks(this);
// userRepository = Mockito.mock(UserRepository.class);

// SignUpForm signUpForm = generator.generateSignUpForm();
// }

// @Test
// public void shouldCreateUser() {
// User user = new ObjectGenerator().generateUser();

// when(userRepository.save(user)).thenReturn(user);

// ResponseEntity<?> response = new SignUpService(userRepository,
// passwordEncoder, signUpForm).execute();

// Assert.assertEquals(201, response.getStatusCodeValue());
// }
// }
