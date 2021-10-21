package com.inatel.gamesalesfinder.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inatel.gamesalesfinder.models.Store;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreDTO {
  private List<String> storeNames;

  public StoreDTO(List<Store> stores) {
    this.storeNames = stores.stream().map(Store::getStoreName).collect(Collectors.toList());
  }
}
