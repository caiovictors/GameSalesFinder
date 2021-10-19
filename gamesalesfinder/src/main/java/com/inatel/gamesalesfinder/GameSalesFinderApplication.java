package com.inatel.gamesalesfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GameSalesFinderApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameSalesFinderApplication.class, args);
	}
}
