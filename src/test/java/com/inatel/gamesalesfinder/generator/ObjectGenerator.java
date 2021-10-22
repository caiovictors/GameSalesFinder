package com.inatel.gamesalesfinder.generator;

import java.util.ArrayList;
import java.util.List;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;

public class ObjectGenerator {
  public User generateUser() {
    return new User("1", "Caio Victor", "caioteste@gmail.com", "password");
  }

  public List<Wishlist> generateWishlist() {
    return new ArrayList<Wishlist>();
  }
}
