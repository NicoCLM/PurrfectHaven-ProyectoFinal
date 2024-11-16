package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.Product;

/**
 * ProductRepository
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    
}
