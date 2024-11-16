package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.PaymentMethods;

/**
 * PaymentMethodsRepository
 */
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer>{

    
}
