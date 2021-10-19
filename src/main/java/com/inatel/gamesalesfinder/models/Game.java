package com.inatel.gamesalesfinder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private String internalName;
	private String title;
	private String metacriticLink;
	private String dealID;
	private String storeID;
	private String gameID;
	private String salePrice;
	private String normalPrice;
	private String isOnSale;
	private String savings;
	private String metacriticScore;
	private String steamRatingText;
	private String steamRatingPercent;
	private String steamRatingCount;
	private String steamAppID;
	private Long releaseDate;
	private Long lastChange;
	private String dealRating;
	private String thumb;
}