// package com.inatel.gamesalesfinder.controller;

// import java.net.URI;

// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.junit.MockitoJUnitRunner;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @RunWith(MockitoJUnitRunner.class)
// @SpringBootTest
// @AutoConfigureMockMvc
// @ActiveProfiles("test")
// public class SignUpControllerTests {
// @Autowired
// private MockMvc mockMvc;

// @Test
// public void shoudCreateUser() throws Exception {
// URI uri = new URI("/auth/signup");
// // String url = SecurityConstants.SIGN_UP_URL;
// String json = "{" + "\"name\": \"saraaaah\", " + "\"email\":
// \"teste@email.com\", " + "\"password\": \"12345\" "
// + "}";

// mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
// .andExpect(MockMvcResultMatchers.status().isCreated());
// }
// }
