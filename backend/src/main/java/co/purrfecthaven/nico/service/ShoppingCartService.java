package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.dto.ShoppingCartDTO;
import co.purrfecthaven.nico.model.Product;
import co.purrfecthaven.nico.model.ShoppingCart;
import co.purrfecthaven.nico.model.User;
import co.purrfecthaven.nico.repository.ProductRepository;
import co.purrfecthaven.nico.repository.ShoppingCartRepository;
import co.purrfecthaven.nico.repository.UserRepository;

/**
 * ShoppingCartService
 */

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRp;

    @Autowired
    private ProductRepository productRp;

    @Autowired
    private UserRepository userRp;

    public Optional<ShoppingCart> getShoppingCartById(Integer id) {
        return shoppingCartRp.findById(id);
    }
    

    public ShoppingCart createShoppingCart(ShoppingCartDTO shoppingCartDTO){
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = productRp.findById(shoppingCartDTO.getProductId()).orElseThrow(()-> new IllegalArgumentException("Producto no encontrado" + shoppingCartDTO.getProductId()));
        User user = userRp.findById(shoppingCartDTO.getUserId()).orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado" + shoppingCartDTO.getUserId()));
       
        shoppingCart.setUser(user);
        shoppingCart.setProduct(product);
        shoppingCart.setAmount(shoppingCartDTO.getAmount());
        shoppingCart.setDateAdded(LocalDateTime.now());
        shoppingCart.setCreatedAt(LocalDateTime.now());
        shoppingCart.setStatus("Activo");
        
        shoppingCartRp.save(shoppingCart);
        return shoppingCart;
    }
    

}
