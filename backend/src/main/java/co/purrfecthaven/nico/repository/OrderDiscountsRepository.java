package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.OrderDiscounts;

/**
 * OrderDiscountsRepository
 */
public interface OrderDiscountsRepository extends JpaRepository<OrderDiscounts, Integer> {

    
}
