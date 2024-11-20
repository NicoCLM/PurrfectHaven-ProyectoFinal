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

import co.purrfecthaven.nico.dto.InventoryDTO;
import co.purrfecthaven.nico.model.Inventory;
import co.purrfecthaven.nico.service.InventoryService;

/**
 * InventoryController
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Inventory>> listInventory() {
        try {
            ArrayList<Inventory> listInventory = this.inventoryService.getInventory();
            return ResponseEntity.ok(listInventory);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }
    }


    @PostMapping
    public ResponseEntity<?> saveInventory(@RequestBody InventoryDTO inventoryDTO){
        try {
            Inventory createdInventory = this.inventoryService.createInventory(inventoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInventory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso no autorizado");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInventoryById(@RequestBody InventoryDTO request, @PathVariable("id") Integer id){
        try {
            Inventory updatedInventory = this.inventoryService.updateInventoryById(request, id);
            return ResponseEntity.ok(updatedInventory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteInventoryById(@PathVariable("id") Integer id){
        try {
            Inventory deletedInventory = this.inventoryService.deleteInventoryById(id);
            return ResponseEntity.ok(deletedInventory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }
}
