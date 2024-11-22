package co.purrfecthaven.nico.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.purrfecthaven.nico.model.Product;

/**
 * ProductRepository
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    ArrayList<Product> findByIsDeletedFalse();

    @Query("SELECT p FROM Product p WHERE p.isDeleted = false AND (:categoryId IS NULL OR p.category.id = :categoryId)")
    ArrayList<Product> findByCategoryAndIsDeleted(@Param("categoryId") Integer categoryId);
}
