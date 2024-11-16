package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.Payments;

/**
 * PaymentsRepository
 */
public interface PaymentsRepository extends JpaRepository<Payments, Integer>{

    
}
