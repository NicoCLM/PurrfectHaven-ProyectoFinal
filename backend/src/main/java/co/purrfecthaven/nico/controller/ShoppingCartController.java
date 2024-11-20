package co.purrfecthaven.nico.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.purrfecthaven.nico.dto.ShoppingCartDTO;
import co.purrfecthaven.nico.model.ShoppingCart;
import co.purrfecthaven.nico.service.ShoppingCartService;



/**
 * ShoppingCartController
 */
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShoppingCartById( @PathVariable("id") Integer id){
        try {
            Optional<ShoppingCart> shoppingCartById = this.shoppingCartService.getShoppingCartById(id);
            return ResponseEntity.ok(shoppingCartById);
        }  catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }

    }

    @PostMapping
    public ResponseEntity<?> saveShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){
        try {
            ShoppingCart createdShoppingCart = this.shoppingCartService.createShoppingCart(shoppingCartDTO); 
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShoppingCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }

    }
}
