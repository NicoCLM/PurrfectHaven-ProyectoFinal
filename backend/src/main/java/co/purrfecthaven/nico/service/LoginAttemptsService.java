package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.LoginAttemptsDTO;
import co.purrfecthaven.nico.model.LoginAttempts;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.LoginAttemptsRepository;
import co.purrfecthaven.nico.repository.UserRepository;

/**
 * LoginAttemptsService
 */

@Service
public class LoginAttemptsService {

    @Autowired
    private LoginAttemptsRepository loginAttemptsRp;

    @Autowired
    private UserRepository userRp;

    public ArrayList<LoginAttempts> getAll(){
        return (ArrayList<LoginAttempts>) loginAttemptsRp.findAll();
    }

    public LoginAttempts createLoginAttempt (LoginAttemptsDTO loginAttemptsDTO, boolean isSuccessful){
        LoginAttempts loginAttempts = new LoginAttempts();
        User user = userRp.findById(loginAttemptsDTO.getUserId()).orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado" + loginAttemptsDTO.getUserId()));

        loginAttempts.setUser(user);
        loginAttempts.setSuccessful(isSuccessful);
        loginAttempts.setCreatedAt(LocalDateTime.now());
        loginAttempts.setAttemptDate(LocalDateTime.now());

        loginAttemptsRp.save(loginAttempts);
        return loginAttempts;
    }
   
}
