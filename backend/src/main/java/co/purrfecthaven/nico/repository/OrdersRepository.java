package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.Orders;

/**
 * OrdersRepository
 */
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    
}
