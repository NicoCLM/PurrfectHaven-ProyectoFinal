package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.UserDTO;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRp;

    public ArrayList<User> getAll(){
        return (ArrayList<User>) userRp.findAll();
    }

    public User createUser(UserDTO userDTO){
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userDTO.getHashedPassword());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setHashedPassword(hashedPassword);
        user.setCreatedAt(LocalDateTime.now());
        userRp.save(user);
        return user;
        
    }

    public User updateUserById(UserDTO request, Integer id){
        User user = userRp.findById(id).get();
        
        user.setUsername(request.getUsername());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        if(request.getHashedPassword()!= null && !request.getHashedPassword().isEmpty()){
             PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
             String hashedPassword = passwordEncoder.encode(request.getHashedPassword());
             user.setHashedPassword(hashedPassword);

        }

        userRp.save(user);
        return user;
    }

    public User deleteUserById(Integer id){
        User user = userRp.findById(id).get();

        user.setIsDeleted(true);
        user.setDeletedAt(LocalDateTime.now());

        userRp.save(user);
        return user;
    }
}
