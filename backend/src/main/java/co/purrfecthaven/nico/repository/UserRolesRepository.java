package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.purrfecthaven.nico.model.UserRoles;

/**
 * UserRolesRepository
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

    
}
