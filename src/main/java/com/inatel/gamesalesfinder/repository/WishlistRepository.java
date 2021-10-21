package com.inatel.gamesalesfinder.repository;

import java.util.List;
import java.util.Optional;

import com.inatel.gamesalesfinder.models.Wishlist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
  Optional<Wishlist> findById(Long id);

  Optional<Wishlist> findByGameName(String gameName);

  List<Optional<Wishlist>> findByUserId(String id);

  Page<Wishlist> findByUserId(String id, Pageable pageable);
}
