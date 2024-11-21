package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.model.UserRoles;

import java.util.ArrayList;
import java.util.List;


/**
 * UserRolesRepository
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

    ArrayList<UserRoles> findByUser_UserId(Integer userId);    
}
