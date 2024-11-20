package co.purrfecthaven.nico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.User;


/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);
}
