package com.inatel.gamesalesfinder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Integer wishlistId;
  private String gameName;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  public Wishlist(Integer wishlistId, String gameName, User user) {
    this.wishlistId = wishlistId;
    this.gameName = gameName;
    this.user = user;
  }
}
