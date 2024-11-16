package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.ProductReviews;

/**
 * ProductReviewsRepository
 */
public interface ProductReviewsRepository extends JpaRepository<ProductReviews,Integer> {

    
}
