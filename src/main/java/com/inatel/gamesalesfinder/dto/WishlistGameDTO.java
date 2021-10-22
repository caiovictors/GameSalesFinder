package com.inatel.gamesalesfinder.dto;

import java.util.List;

import com.inatel.gamesalesfinder.models.Store;

import lombok.Data;

@Data
public class WishlistGameDTO {
  private Long wishlistGameId;
  private String gameName;
  private String gamePrice;
  private List<String> stores;

  public WishlistGameDTO(Long wishlistGameId, String gameName, String gamePrice, List<Store> stores) {
    this.wishlistGameId = wishlistGameId;
    this.gameName = gameName;
    this.gamePrice = gamePrice;
    this.stores = new StoreDTO(stores).getStoreNames();
  }
}
