package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User createUser(User user){
        return userRp.save(user);
    }

    public User updateUserById(User request, Integer id){
        User user = userRp.findById(id).get();
        
        user.setUsername(request.getUsername());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setHashedPassword(request.getHashedPassword());


        userRp.save(user);
        return user;
    }

    public User deleteUserById(User request, Integer id){
        User user = userRp.findById(id).get();

        user.setIsDeleted(true);

        if(request.getIsDeleted()){
            user.setDeletedAt(LocalDateTime.now());
        }

        userRp.save(user);
        return user;
    }
}
