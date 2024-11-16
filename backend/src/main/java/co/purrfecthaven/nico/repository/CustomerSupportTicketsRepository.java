package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.CustomerSupportTickets;

/**
 * CustomerSupportTicketsRepository
 */
public interface CustomerSupportTicketsRepository extends JpaRepository<CustomerSupportTickets, Integer> {

    
}
