package co.purrfecthaven.nico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.ShoppingCart;

/**
 * ShoppingCartRepository
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findByUser_UserId(Integer userId);
    
}
