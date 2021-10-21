package com.inatel.gamesalesfinder.services;

import java.util.Optional;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.repository.UserRepository;

import org.springframework.security.core.context.SecurityContextHolder;

public class GetUserByTokenService {
  public Optional<User> run(UserRepository UserRepository) {
    String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Optional<User> optionalUser = UserRepository.findByEmail(userEmail);

    if (!optionalUser.isPresent()) {
      return null;
    }

    return optionalUser;
  }
}
