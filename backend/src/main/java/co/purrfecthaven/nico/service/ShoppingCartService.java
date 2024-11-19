package co.purrfecthaven.nico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.ShoppingCart;
import co.purrfecthaven.nico.repository.ShoppingCartRepository;

/**
 * ShoppingCartService
 */

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRp;

    public Optional<ShoppingCart> getShoppingCartById(Integer id){
        return shoppingCartRp.findById(id);
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRp.save(shoppingCart);
    }

}
