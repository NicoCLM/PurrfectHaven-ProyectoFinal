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
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> listUsers(){
        try {
          ArrayList<User> getUsers = this.userService.getAll();
          return ResponseEntity.ok(getUsers);
        }
        catch (Exception e) {
          return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        try {
           User createdUser = this.userService.createUser(userDTO); 
           return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        boolean isAuthenticated = this.userService.authenticate(userDTO.getUsername(), userDTO.getHashedPassword());

        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.OK).body("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
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
