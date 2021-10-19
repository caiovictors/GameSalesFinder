package com.inatel.gamesalesfinder.repository;

import java.util.Optional;

import com.inatel.gamesalesfinder.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}
