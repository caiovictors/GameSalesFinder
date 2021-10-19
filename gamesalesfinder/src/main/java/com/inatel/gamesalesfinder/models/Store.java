package com.inatel.gamesalesfinder.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
  private String storeID;
  private String storeName;
  private Boolean isActive;
}
