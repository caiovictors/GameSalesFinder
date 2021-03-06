package com.inatel.gamesalesfinder.generator;

import java.util.ArrayList;
import java.util.List;

import com.inatel.gamesalesfinder.forms.SignInForm;
import com.inatel.gamesalesfinder.forms.SignUpForm;
import com.inatel.gamesalesfinder.forms.WishlistForm;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;

public class ObjectGenerator {
  public User generateUser() {
    return new User("1", "Caio Victor", "caioteste@gmail.com", "password");
  }

  public Wishlist generateWishlistGame() {
    User user = generateUser();
    return new Wishlist(1L, "Mad Max", user);
  }

  public List<Wishlist> generateWishlist() {
    return new ArrayList<Wishlist>();
  }

  public WishlistForm generateWishlistForm() {
    return new WishlistForm("Mad Max");
  }

  public SignUpForm generateSignUpForm() {
    return new SignUpForm("Caio Victor", "caioteste@gmail.com", "password");
  }

  public SignInForm generateSignInForm() {
    return new SignInForm("caioteste@gmail.com", "password");
  }
}
