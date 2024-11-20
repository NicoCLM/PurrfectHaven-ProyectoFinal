package co.purrfecthaven.nico.controller;

import java.util.ArrayList;

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

import co.purrfecthaven.nico.dto.OrderDetailsDTO;
import co.purrfecthaven.nico.model.OrderDetails;
import co.purrfecthaven.nico.service.OrderDetailsService;


/**
 * OrderDetailsController
 */
@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

   @Autowired
    private OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService){
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<OrderDetails>> getOrderDetails() {
        try{
            ArrayList<OrderDetails> listOrderDetails = this.orderDetailsService.getAll();
            return ResponseEntity.ok(listOrderDetails);

        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }

    }


    @PostMapping
    public ResponseEntity<?> saveOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO){
        try {
            OrderDetails createdOrderDetails = this.orderDetailsService.createOrderDetails(orderDetailsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDetails);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrderDetailsById(@RequestBody OrderDetailsDTO request, @PathVariable("id") Integer id){
        try {
            OrderDetails updatedOrderDetails = this.orderDetailsService.updateOrderDetailsById(request, id);
            return ResponseEntity.ok(updatedOrderDetails);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }



}
