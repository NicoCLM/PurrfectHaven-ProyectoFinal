package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * InventoryDTO
 */
public class InventoryDTO {

    private int inventoryId;
    private int productId;
    private int stockLevel;
    private LocalDateTime lastUpdated;


    //Getters & Setters
    
    public int getInventoryId() {
        return this.inventoryId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockLevel() {
        return this.stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
