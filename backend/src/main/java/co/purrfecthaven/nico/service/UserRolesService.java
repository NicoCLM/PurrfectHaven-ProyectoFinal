package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.UserRolesDTO;
import co.purrfecthaven.nico.model.UserRoles;
import co.purrfecthaven.nico.model.Roles;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.RolesRepository;
import co.purrfecthaven.nico.repository.UserRepository;
import co.purrfecthaven.nico.repository.UserRolesRepository;

/**
 * UserRolesService
 */

@Service
public class UserRolesService {

    @Autowired
    private UserRolesRepository userRolesRp;
    @Autowired
    private UserRepository userRp;
    @Autowired
    private RolesRepository rolesRp;


    public ArrayList<UserRoles> getUserRoles(){
        return (ArrayList<UserRoles>) userRolesRp.findAll();
    }

    public UserRoles createUserRole(UserRolesDTO userRolesDTO){
        UserRoles userRoles = new UserRoles();
        User user = userRp.findById(userRolesDTO.getUserId()).orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado " + userRolesDTO.getUserId()));
        Roles roles = rolesRp.findById(userRolesDTO.getRoleId()).orElseThrow(() -> new IllegalArgumentException("Rol no encontrado " + userRolesDTO.getRoleId()));

        userRoles.setUser(user);
        userRoles.setRoles(roles);
        userRoles.setCreatedAt(LocalDateTime.now());
        
        userRolesRp.save(userRoles);
        return userRoles;
    }

    public UserRoles deleteUserRoleById(Integer id){
        UserRoles userRoles = userRolesRp.findById(id).get();

        userRoles.setIsDeleted(true);
        userRoles.setDeletedAt(LocalDateTime.now());

        userRolesRp.save(userRoles);
        return userRoles;
    }
    
    public ArrayList<UserRoles> findUserRole (Integer id){
         return userRolesRp.findByUser_UserId(id);
    }
}
