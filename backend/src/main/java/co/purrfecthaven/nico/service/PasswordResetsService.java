package co.purrfecthaven.nico.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.PasswordResets;
import co.purrfecthaven.nico.repository.PasswordResetsRepository;

/**
 * PasswordResetsService
 */

@Service
public class PasswordResetsService {

    private PasswordResetsRepository passwordResetsRp;

    public PasswordResets createPasswordResets(PasswordResets passwordResets){
        return passwordResetsRp.save(passwordResets);
    }
}
