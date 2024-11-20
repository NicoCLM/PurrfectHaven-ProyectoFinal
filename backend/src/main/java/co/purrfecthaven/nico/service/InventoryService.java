package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.Inventory;
import co.purrfecthaven.nico.model.Product;
import co.purrfecthaven.nico.repository.InventoryRepository;
import co.purrfecthaven.nico.repository.ProductRepository;
import co.purrfecthaven.nico.dto.InventoryDTO;
/**
 * InventoryService
 */

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRp;

    @Autowired
    private ProductRepository productRp;

    public ArrayList<Inventory> getInventory(){
        return (ArrayList<Inventory>) inventoryRp.findAll();
    }

    public Inventory createInventory(InventoryDTO inventoryDTO){
        Inventory inventory = new Inventory();
        Product product = productRp.findById(inventoryDTO.getProductId()).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado" + inventoryDTO.getProductId()));

        inventory.setProduct(product);
        inventory.setStockLevel(inventoryDTO.getStockLevel());
        inventory.setCreatedAt(LocalDateTime.now());
        inventory.setLastUpdated(LocalDateTime.now());

        inventoryRp.save(inventory);
        return inventory;
    }

    public Inventory updateInventoryById(InventoryDTO request, Integer id){
        Inventory inventory = inventoryRp.findById(id).get();
        Product product = productRp.findById(request.getProductId()).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado " + request.getProductId()));
        
        inventory.setProduct(product);
        inventory.setLastUpdated(LocalDateTime.now());

        inventoryRp.save(inventory);
        return inventory;
    }

    public Inventory deleteInventoryById(Integer id){
        Inventory inventory = inventoryRp.findById(id).get();

        inventory.setIsDeleted(true);
        inventory.setDeletedAt(LocalDateTime.now());

        inventoryRp.save(inventory);
        return inventory;
    }
   
}
