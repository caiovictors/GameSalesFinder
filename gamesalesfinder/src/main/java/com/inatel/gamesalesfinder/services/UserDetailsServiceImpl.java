package com.inatel.gamesalesfinder.services;

import com.inatel.gamesalesfinder.models.User;
import com.inatel.gamesalesfinder.models.UserDetailsImpl;
import com.inatel.gamesalesfinder.repository.UserRepository;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
    Optional<User> user = userRepository.findByEmail(email);
    if (!user.isPresent()) {
      throw new UsernameNotFoundException("Could not find user with name '" + email + "'");
    } else {
      return new UserDetailsImpl(user.get());
    }
  }
}