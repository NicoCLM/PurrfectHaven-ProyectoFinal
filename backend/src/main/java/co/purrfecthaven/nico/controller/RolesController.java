package co.purrfecthaven.nico.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.RolesDTO;
import co.purrfecthaven.nico.exception.RolesNotFoundException;
import co.purrfecthaven.nico.model.Roles;
import co.purrfecthaven.nico.service.RolesService;

/**
 * RolesController
 */

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    public RolesController(RolesService rolesService){
        this.rolesService = rolesService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Roles>> listRoless(){
        try {
            ArrayList<Roles> getRoles = this.rolesService.getRoles();
            return ResponseEntity.ok(getRoles);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }

    @PostMapping
    public ResponseEntity<?> saveRoles(@RequestBody RolesDTO rolesDTO){
        try {
           Roles createdRoles = this.rolesService.createRoles(rolesDTO); 
           return ResponseEntity.status(HttpStatus.CREATED).body(createdRoles);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRolesById(@RequestBody RolesDTO request, @PathVariable("id") Integer id){
        try {
             Roles updatedRoles = this.rolesService.updateRolesById(request, id);
             return ResponseEntity.ok(updatedRoles);
        } catch (RolesNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
        
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteRolesById(@PathVariable("id") Integer id){
        try {
            Roles deletedRoles = this.rolesService.deleteRolesById(id);
            return ResponseEntity.ok(deletedRoles);
        } catch (RolesNotFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
