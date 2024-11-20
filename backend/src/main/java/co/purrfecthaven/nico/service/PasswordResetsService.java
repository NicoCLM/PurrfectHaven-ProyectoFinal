package co.purrfecthaven.nico.service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.PasswordResetsDTO;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.model.PasswordResets;
import co.purrfecthaven.nico.repository.PasswordResetsRepository;
import co.purrfecthaven.nico.repository.UserRepository;
import co.purrfecthaven.nico.utils.RandomToken;

/**
 * PasswordResetsService
 */

@Service
public class PasswordResetsService {


    @Autowired
    private PasswordResetsRepository passwordResetsRp;

    @Autowired
    private UserRepository userRp;

    public PasswordResets createPasswordResets(PasswordResetsDTO passwordResetsDTO){
        PasswordResets passwordResets = new PasswordResets();
        User user = userRp.findById(passwordResetsDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado" + passwordResetsDTO.getUserId()));
        RandomToken newToken = new RandomToken();

        passwordResets.setCreatedAt(LocalDateTime.now());
        passwordResets.setTokenExpiry(LocalDateTime.now().plusMinutes(60));
        passwordResets.setResetToken(newToken.generateRandomToken());
        passwordResets.setUser(user);

        passwordResetsRp.save(passwordResets);
        return passwordResets;
    }

    public boolean validateResetToken(Integer id) {
        PasswordResets passwordResets = passwordResetsRp.findById(id).get();

        if (passwordResets.getResetToken() != null && LocalDateTime.now().isBefore(passwordResets.getTokenExpiry())) {
            return true;
        }

        return false;
    }
}
