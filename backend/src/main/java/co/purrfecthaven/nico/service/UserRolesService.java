package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.UserRoles;
import co.purrfecthaven.nico.repository.UserRolesRepository;

/**
 * UserRolesService
 */

@Service
public class UserRolesService {

    @Autowired
    private UserRolesRepository userRolesRp;

    public ArrayList<UserRoles> getUserRoles(){
        return (ArrayList<UserRoles>) userRolesRp.findAll();
    }

    public UserRoles createUserRole(UserRoles userRoles){
        return userRolesRp.save(userRoles);
    }

}
