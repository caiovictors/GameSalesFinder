package com.inatel.gamesalesfinder.repository;

import java.util.List;
import java.util.Optional;

import com.inatel.gamesalesfinder.models.Wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
  Optional<Wishlist> findById(Long id);

  List<Optional<Wishlist>> findByUserId(String id);
}
