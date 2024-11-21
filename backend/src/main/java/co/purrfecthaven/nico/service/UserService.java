package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.exception.*;
import co.purrfecthaven.nico.dto.UserDTO;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRp;

    public ArrayList<User> getAll(){
        logger.info("Fetch Users");
        return (ArrayList<User>) userRp.findAll();
    }

    public User createUser(UserDTO userDTO){
        User user = new User();
        try {
            System.out.println("Creating user with username: " + userDTO.getUsername());
            if (userDTO.getHashedPassword() != null && !userDTO.getHashedPassword().isEmpty()) {
                user.setHashedPassword(userDTO.getHashedPassword());
                logger.info("Password set for user: ", userDTO.getUsername());
            }

            user.setUsername(userDTO.getUsername());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setCreatedAt(LocalDateTime.now());

            if (userDTO.getPhone() == null || userDTO.getPhone().isEmpty()) {
                user.setPhone(null); 
            } else {
                user.setPhone(userDTO.getPhone());
            }

            if (userDTO.getAddress() == null || userDTO.getAddress().isEmpty()) {
                user.setAddress(null); 
            } else {
                user.setAddress(userDTO.getAddress());
            }

            userRp.save(user);
            logger.info("User created succesful", user.getUsername());
            return user;

        } catch (Exception e) {
            logger.info("Error", e);
            return user;
        }
    }


    public User updateUserById(UserDTO request, Integer id){
        System.out.println("Updating user with ID: " + id);
        User user = userRp.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setUsername(request.getUsername());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        if (request.getHashedPassword() != null && !request.getHashedPassword().isEmpty()) {
            user.setHashedPassword(request.getHashedPassword());
            System.out.println("Password updated successfully for user ID: " + id);
        }

        userRp.save(user);
        System.out.println("User updated successfully with ID: " + id);
        return user;
    }

    public User deleteUserById(Integer id){
        System.out.println("Deleting user with ID: " + id);
        User user = userRp.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario No encotnrado"));

        user.setIsDeleted(true);
        user.setDeletedAt(LocalDateTime.now());

        userRp.save(user);
        System.out.println("User marked as deleted with ID: " + id);
        return user;
    }

    public boolean authenticate(String username, String rawPassword) {
        User user = userRp.findByUsername(username).orElse(null);
        logger.info("User to auth: ",username);
        if (user == null) {
            logger.error("User not found", username);
            return false; 
        }
        boolean matches = rawPassword.equals(user.getHashedPassword());
        if (matches) {
            logger.info("Authentication successful", username);
        } else {
            logger.error("Authentication failed", username);
        }
        return matches;
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRp.findByUsername(username);

        if (user.isPresent()) {
            return user.get(); 
        } else {

            throw new UserNotFoundException("Usuario no encontrado");
        }
    }

}


