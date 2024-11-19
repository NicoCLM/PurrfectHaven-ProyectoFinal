package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.RolesDTO;
import co.purrfecthaven.nico.model.Roles;
import co.purrfecthaven.nico.repository.RolesRepository;

/**
 * RolesService
 */

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRp;

    public ArrayList<Roles> getRoles(){
        return (ArrayList<Roles>)rolesRp.findAll();
    }

    public Roles createRoles(RolesDTO rolesDTO){
        Roles roles = new Roles();
        
        roles.setCreatedAt(LocalDateTime.now());
        roles.setRoleName(rolesDTO.getRoleName());
        roles.setDescription(rolesDTO.getDescription());
        
        rolesRp.save(roles);
        return roles;

    }



    public Roles deleteRolesById(Integer id){
        Roles roles = rolesRp.findById(id).get();

        roles.setIsDeleted(true);
        roles.setDeletedAt(LocalDateTime.now());

        rolesRp.save(roles);
        return roles;
    }
}
