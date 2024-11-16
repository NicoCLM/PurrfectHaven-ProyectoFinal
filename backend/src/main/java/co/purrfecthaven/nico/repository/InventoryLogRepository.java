package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.InventoryLog;

/**
 * InventoryLogRepository
 */
public interface InventoryLogRepository extends JpaRepository<InventoryLog, Integer> {

    
}
