package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.LoginAttempts;
import co.purrfecthaven.nico.repository.LoginAttemptsRepository;

/**
 * LoginAttemptsService
 */

@Service
public class LoginAttemptsService {

    @Autowired
    private LoginAttemptsRepository loginAttemptsRp;

    public ArrayList<LoginAttempts> getAll(){
        return (ArrayList<LoginAttempts>) loginAttemptsRp.findAll();
    }

    public LoginAttempts createLoginAttempt (LoginAttempts loginAttempt){
        return loginAttemptsRp.save(loginAttempt);
    }

   
}
