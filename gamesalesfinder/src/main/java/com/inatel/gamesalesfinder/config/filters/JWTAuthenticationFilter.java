package com.inatel.gamesalesfinder.config.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.inatel.gamesalesfinder.dto.SignInDTO;
import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.UserDetailsImpl;
import com.inatel.gamesalesfinder.variables.SecurityConstants;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;

    setFilterProcessesUrl("/auth/signin");
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException {
    try {
      User credentials = new ObjectMapper().readValue(req.getInputStream(), User.class);

      return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getEmail(),
          credentials.getPassword(), new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
      Authentication auth) throws IOException {
    res.setContentType("application/json");
    UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();

    String token = JWT.create().withSubject(user.getUser().getEmail())
        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
        .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

    String json = new Gson().toJson(new SignInDTO(user.getUser(), token));
    res.getWriter().write(json);
    res.getWriter().flush();
  }
}
