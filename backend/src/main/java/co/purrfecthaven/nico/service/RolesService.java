package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Roles createRoles(Roles roles){
        return rolesRp.save(roles);
    }



    public Roles deleteRolesById(Roles request, Integer id){
        Roles roles = rolesRp.findById(id).get();

        roles.setIsDeleted(true);
        roles.setDeletedAt(LocalDateTime.now());

        rolesRp.save(roles);
        return roles;
    }
}
