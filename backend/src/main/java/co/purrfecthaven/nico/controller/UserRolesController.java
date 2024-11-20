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

import co.purrfecthaven.nico.dto.UserRolesDTO;
import co.purrfecthaven.nico.model.UserRoles;
import co.purrfecthaven.nico.service.UserRolesService;

/**
 * UserRolesRolesController
 */

@RestController
@RequestMapping("/userRoles")
public class UserRolesController {
    
    @Autowired
    private UserRolesService userRolesService;

    public UserRolesController(UserRolesService userRolesService){
        this.userRolesService = userRolesService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<UserRoles>> listUserRoless(){
        try {
            ArrayList<UserRoles> getUserRoless = this.userRolesService.getUserRoles();
            return ResponseEntity.ok(getUserRoless);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUserRoles(@RequestBody UserRolesDTO userRolesDTO){
        try {
           UserRoles createdUserRoles = this.userRolesService.createUserRole(userRolesDTO); 
           return ResponseEntity.status(HttpStatus.CREATED).body(createdUserRoles);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }

    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserRolesById(@PathVariable("id") Integer id){
        try {
            UserRoles deletedUserRoles = this.userRolesService.deleteUserRoleById(id);
            return ResponseEntity.ok(deletedUserRoles);
        }  catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
