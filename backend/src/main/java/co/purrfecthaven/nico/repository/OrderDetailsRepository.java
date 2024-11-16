package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.OrderDetails;

/**
 * OrderDetailsRepository
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    
}
