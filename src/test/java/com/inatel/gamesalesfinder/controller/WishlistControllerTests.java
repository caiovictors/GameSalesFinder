package com.inatel.gamesalesfinder.controller;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.inatel.gamesalesfinder.forms.WishlistForm;
import com.inatel.gamesalesfinder.generator.ObjectGenerator;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;
import com.inatel.gamesalesfinder.repository.UserRepository;
import com.inatel.gamesalesfinder.repository.WishlistRepository;
import com.inatel.gamesalesfinder.services.AddGameToWishlistService;
import com.inatel.gamesalesfinder.services.GetGameFromWishlistService;
import com.inatel.gamesalesfinder.services.RemoveGameFromWishlistService;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class WishlistControllerTests {
  @Autowired
  private UserRepository userRepository;
  private WishlistRepository wishlistRepository;

  private Authentication authentication;
  private SecurityContext securityContext;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    userRepository = Mockito.mock(UserRepository.class);
    wishlistRepository = Mockito.mock(WishlistRepository.class);
    authentication = Mockito.mock(Authentication.class);
    securityContext = Mockito.mock(SecurityContext.class);

    when(securityContext.getAuthentication()).thenReturn(authentication);
    SecurityContextHolder.setContext(securityContext);
  }

  @Test
  public void shouldAddToWishlist() {
    User user = new ObjectGenerator().generateUser();
    WishlistForm wishlistForm = new WishlistForm();
    wishlistForm.setGameName("Mad Max");

    when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
    when(wishlistRepository.save(Mockito.any())).thenReturn(new Wishlist());

    ResponseEntity<?> response = new AddGameToWishlistService().execute(wishlistRepository, userRepository,
        wishlistForm);
    Assert.assertEquals(201, response.getStatusCodeValue());
  }

  // @Test
  // public void shouldNotAddToWishlist() {
  // User user = new ObjectGenerator().generateUser();
  // Wishlist wishlist = new ObjectGenerator().generateWishlistGame();

  // WishlistForm wishlistForm = new WishlistForm();
  // wishlistForm.setGameName("Mad Max");

  // when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
  // when(wishlistRepository.save(wishlist)).thenReturn(wishlist);
  // when(wishlistRepository.findByGameName(wishlistForm.getGameName())).thenReturn(Optional.of(wishlist));
  // // when()
  // // when(wishlistRepository.findByUserId(id)).thenReturn(new Wishlist());
  // //
  // when(wishlistRepository.findByGameNameAndUserId(wishlistForm.getGameName(),user.getId()).thenReturn(Optional.of(wishlist)));
  // //
  // when(wishlistRepository.findById(wishlist.getId()).thenReturn(Optional()));

  // // Student student = factory.studentBuilder();
  // // Discipline discipline = factory.disciplineBuilder();
  // // DisciplinesForm disciplinesForm = new DisciplinesForm("Mathematics");
  // //
  // when(studentRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(student));
  // // when(disciplineRepository.findByDisciplineNameAndStudent("Mathematics",
  // // student.getId())).thenReturn(Optional.of(discipline));

  // ResponseEntity<?> response = new
  // AddGameToWishlistService().execute(wishlistRepository, userRepository,
  // wishlistForm);
  // Assert.assertEquals(409, response.getStatusCodeValue());

  // DisciplinesForm disciplinesForm = new DisciplinesForm("Mathematics");
  // when(studentRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(student));
  // when(disciplineRepository.findByDisciplineNameAndStudent("Mathematics",
  // student.getId())).thenReturn(Optional.of(discipline));

  // createDisciplineService = new CreateDisciplineService(studentRepository,
  // disciplineRepository, disciplinesForm);
  // ResponseEntity<?> createDisciplineServiceExecution =
  // createDisciplineService.run();

  // assertEquals(createDisciplineServiceExecution.getStatusCode(),
  // HttpStatus.CONFLICT);
  // }

  @Test
  public void shouldGetWishlist() {
    User user = new ObjectGenerator().generateUser();
    Pageable pageable = PageRequest.of(0, 10);
    List<Wishlist> wishlist = new ObjectGenerator().generateWishlist();
    Page<Wishlist> wishlistPaged = new PageImpl<Wishlist>(wishlist);

    when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
    when(wishlistRepository.findByUserId(user.getId(), pageable)).thenReturn(wishlistPaged);

    ResponseEntity<?> response = new GetGameFromWishlistService().execute(userRepository, wishlistRepository, pageable);
    Assert.assertEquals(200, response.getStatusCodeValue());
  }

  // @Test
  // public void shouldNotGetWishlist() {
  // User user = new ObjectGenerator().generateUser();
  // Pageable pageable = PageRequest.of(0, 10);
  // // List<Wishlist> wishlist = new ObjectGenerator().generateWishlist();
  // // Page<Wishlist> wishlistPaged = new PageImpl<Wishlist>(wishlist);

  // when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
  // // when(wishlistRepository.findByUserId("2").thenReturn(Optional.empty()));
  // when(wishlistRepository.findByUserId("2", pageable)).thenReturn(null);

  // ResponseEntity<?> response = new
  // GetGameFromWishlistService().execute(userRepository, wishlistRepository,
  // pageable);
  // Assert.assertEquals(200, response.getStatusCodeValue());
  // }

  @Test
  public void shouldDeleteGameFromWishlist() {
    User user = new ObjectGenerator().generateUser();
    Wishlist wishlist = new Wishlist(31L, "Sunset Overdrive", user);
    when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
    when(wishlistRepository.findById(31L)).thenReturn(Optional.of(wishlist));

    RemoveGameFromWishlistService removeGameFromWishlistService = new RemoveGameFromWishlistService();
    ResponseEntity<?> response = removeGameFromWishlistService.delete(wishlistRepository, userRepository, 31L);
    Assert.assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void shouldNotDeleteGameFromWishlist() {
    User user = new ObjectGenerator().generateUser();
    Wishlist wishlist = new Wishlist(31L, "Sunset Overdrive", user);
    when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(user));
    when(wishlistRepository.findById(31L)).thenReturn(Optional.of(wishlist));

    RemoveGameFromWishlistService removeGameFromWishlistService = new RemoveGameFromWishlistService();
    ResponseEntity<?> response = removeGameFromWishlistService.delete(wishlistRepository, userRepository, 32L);
    Assert.assertEquals(404, response.getStatusCodeValue());
  }
}
