package co.purrfecthaven.nico.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.ShoppingCartDTO;
import co.purrfecthaven.nico.model.ShoppingCart;
import co.purrfecthaven.nico.service.ShoppingCartService;



/**
 * ShoppingCartController
 */
@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }
    @GetMapping
    public ResponseEntity<ArrayList<ShoppingCart>> listCategory() {
        try {
            ArrayList<ShoppingCart> getCategory = this.shoppingCartService.getAll();
            return ResponseEntity.ok(getCategory);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable("user_id") Integer userId) {
        try {
            Optional<ShoppingCart> shoppingCartOptional = shoppingCartService.getCartByUserId(userId);
            if (shoppingCartOptional.isPresent()) {
                return ResponseEntity.ok(shoppingCartOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado para el usuario.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el carrito");
        }
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
