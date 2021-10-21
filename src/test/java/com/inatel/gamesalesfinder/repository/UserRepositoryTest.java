// package com.inatel.gamesalesfinder.repository;

// import java.util.Optional;

// import com.inatel.gamesalesfinder.models.User;

// import org.junit.Assert;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.junit4.SpringRunner;

// import lombok.AllArgsConstructor;

// @RunWith(SpringRunner.class)
// // @DataJpaTest
// @AutoConfigureMockMvc
// @ActiveProfiles("test")
// @SpringBootTest
// // @AllArgsConstructor
// public class UserRepositoryTest {
// @Autowired
// private UserRepository userRepository;

// @Test
// public void shouldFindByEmail() {
// String email = "caio@gmail.com";
// User user = userRepository.findByEmail(email).get();

// Assert.assertEquals(user.getEmail(), email);
// }
// }
