package co.purrfecthaven.nico.utils;

import java.util.UUID;

/**
 * RandomToken
 */
public class RandomToken {

    public String generateRandomToken(){
        return UUID.randomUUID().toString();
    }
}
