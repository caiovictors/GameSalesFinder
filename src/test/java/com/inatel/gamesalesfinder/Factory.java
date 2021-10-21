package com.inatel.gamesalesfinder;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.Wishlist;

public class Factory {
  public User userBuilder() {
    return new User("Caio Victor", "caio@gmail.com", "risos");
  }

  public Wishlist wishlistBuilder() {
    return new Wishlist("Sunset Overdrive", userBuilder());
  }
  // public FlashCardsForm flashCardFormBuilder() {
  // return new FlashCardsForm("Pi with 2 decimal points", "3.14", "Mathematics");
  // }

  // public FlashCard flashCardBuilder() {
  // return new FlashCard("1", "Pi with 2 decimal points", "3.14", new Date(), 0,
  // disciplineBuilder());
  // }

  // public FlashCard futureFlashCardBuilder() {
  // return new FlashCard("2", "How to calculate the volume of a cylinder?",
  // "Pi*R^2*h", new DateTime(new Date()).plusDays(10).toDate(), 0,
  // disciplineBuilder());
  // }

  // public Student studentBuilder() {
  // return new Student("1", "test", "test@mail.com", "123456", new
  // HashSet<Discipline>());
  // }

  // public Discipline disciplineBuilder() {
  // return new Discipline("Mathematics", studentBuilder());
  // }
}
