package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.PasswordResets;

/**
 * PasswordResetsRepository
 */
public interface PasswordResetsRepository  extends JpaRepository<PasswordResets, Integer>{

    
}
