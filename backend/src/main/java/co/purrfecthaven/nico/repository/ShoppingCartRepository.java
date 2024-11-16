package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.ShoppingCart;

/**
 * ShoppingCartRepository
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    
}
