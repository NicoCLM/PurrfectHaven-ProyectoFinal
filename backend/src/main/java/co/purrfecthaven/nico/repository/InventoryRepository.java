package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.Inventory;

/**
 * InventoryRepository
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    
}
