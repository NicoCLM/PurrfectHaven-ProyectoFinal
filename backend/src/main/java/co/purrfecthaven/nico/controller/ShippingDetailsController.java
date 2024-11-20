package co.purrfecthaven.nico.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.ShippingDetailsDTO;
import co.purrfecthaven.nico.exception.ShippingDetailsNotFoundException;
import co.purrfecthaven.nico.model.ShippingDetails;
import co.purrfecthaven.nico.service.ShippingDetailsService;

/**
 * ShippingDetailsController
 */
@RestController
@RequestMapping("/api/shippingDetails")
public class ShippingDetailsController {

    @Autowired
    private ShippingDetailsService shippingDetailsService;

    public ShippingDetailsController(ShippingDetailsService shippingDetailsService){
        this.shippingDetailsService = shippingDetailsService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<ShippingDetails>> listShippingDetailss(){
        try{
            ArrayList<ShippingDetails> getShippingDetails = this.shippingDetailsService.getShippingDetails();
            return ResponseEntity.ok(getShippingDetails);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShippingDetailsById( @PathVariable("id") Integer id){
        try {
             Optional<ShippingDetails> shippingDetailsById = this.shippingDetailsService.getShippingDetailsById(id);
             return ResponseEntity.ok(shippingDetailsById);
        } catch (ShippingDetailsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalles del Envio no encontrados");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
        
    }

    @PostMapping
    public ResponseEntity<?> saveShippingDetails(@RequestBody ShippingDetailsDTO shippingDetailsDTO){
        try {
           ShippingDetails createdShippingDetails = this.shippingDetailsService.createShippingDetails(shippingDetailsDTO); 
           return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingDetails);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateShippingDetailsById(@RequestBody ShippingDetailsDTO request, @PathVariable("id") Integer id){
        try {
             ShippingDetails updatedShippingDetails = this.shippingDetailsService.updateShippingDetailsById(request, id);
             return ResponseEntity.ok(updatedShippingDetails);
        } catch (ShippingDetailsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalles del Envio no encontrados");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
        
    }

}
