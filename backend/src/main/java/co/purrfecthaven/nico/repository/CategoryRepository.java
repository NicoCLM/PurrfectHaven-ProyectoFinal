package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.Category;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    
}
