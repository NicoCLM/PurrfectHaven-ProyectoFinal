package co.purrfecthaven.nico.controller;

import org.springframework.web.bind.annotation.RestController;

import co.purrfecthaven.nico.dto.OrdersDTO;
import co.purrfecthaven.nico.model.Orders;
import co.purrfecthaven.nico.service.OrdersService;

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

/**
 * OrdersController
 */

@RestController
@RequestMapping("/orders")
public class OrdersController {
    
    @Autowired
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Orders>> getOrders() {
        try {
            ArrayList<Orders> listOrders = this.ordersService.getOrders();
            return ResponseEntity.ok(listOrders);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }


    @PostMapping
    public ResponseEntity<?> saveOrders(@RequestBody OrdersDTO ordersDTO){
        try {
            Orders createdOrders = this.ordersService.createOrders(ordersDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrdersById(@RequestBody OrdersDTO request, @PathVariable("id") Integer id){
        try {
            Orders updatedOrders = this.ordersService.updateOrder(request, id);
            return ResponseEntity.ok(updatedOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }
}
