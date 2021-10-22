package com.inatel.gamesalesfinder.variables;

public class SecurityConstants {
  public static final String SECRET = "SECRET_KEY";
  public static final long EXPIRATION_TIME = 900_000; // 15 mins
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/auth/signup";

  public static final String BASE_URL = "https://www.cheapshark.com/api/1.0/deals?sortBy=Price&exact=1&title=";
  public static final String STORE_URL = "https://www.cheapshark.com/api/1.0/stores";
  public static final String SWAGGER_URL = "/swagger-ui/**";
}
