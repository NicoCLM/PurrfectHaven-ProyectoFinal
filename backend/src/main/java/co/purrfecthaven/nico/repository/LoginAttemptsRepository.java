package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.LoginAttempts;

/**
 * LoginAttemptsRepository
 */
public interface LoginAttemptsRepository extends JpaRepository<LoginAttempts,Integer> {

    
}
