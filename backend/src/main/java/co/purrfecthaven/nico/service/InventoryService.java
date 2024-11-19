package co.purrfecthaven.nico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import co.purrfecthaven.nico.model.Inventory;
import co.purrfecthaven.nico.repository.InventoryRepository;

/**
 * InventoryService
 */

@Service
public class InventoryService {
    
    private InventoryRepository inventoryRp;

    public ArrayList<Inventory> getInventory(){
        return (ArrayList<Inventory>) inventoryRp.findAll();
    }

    public Inventory createInventory(Inventory inventory){
        return inventoryRp.save(inventory);
    }

    public Inventory updateInventoryById(Inventory request, Integer id){
        Inventory inventory = inventoryRp.findById(id).get();
        
        inventory.setLastUpdated(LocalDateTime.now());

        inventoryRp.save(inventory);
        return inventory;
    }

    public Inventory deleteInventoryById(Inventory request, Integer id){
        Inventory inventory = inventoryRp.findById(id).get();

        inventory.setIsDeleted(true);

        if(request.getIsDeleted()){
            inventory.setDeletedAt(LocalDateTime.now());
        }

        inventoryRp.save(inventory);
        return inventory;
    }
   
}
