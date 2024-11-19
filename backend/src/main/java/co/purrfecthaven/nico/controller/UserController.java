package co.purrfecthaven.nico.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.service.UserService;
import co.purrfecthaven.nico.dto.UserDTO;
import co.purrfecthaven.nico.exception.UserNotFoundException;
import co.purrfecthaven.nico.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * User
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> listUsers(){
        ArrayList<User> getUsers = this.userService.getAll();
        return ResponseEntity.ok(getUsers);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO){
        User createdUser = this.userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@RequestBody UserDTO request, @PathVariable("id") Integer id){
        try {
             User updatedUser = this.userService.updateUserById(request, id);
             return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
        
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
        try {
            User deletedUser = this.userService.deleteUserById(id);
            return ResponseEntity.ok(deletedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
