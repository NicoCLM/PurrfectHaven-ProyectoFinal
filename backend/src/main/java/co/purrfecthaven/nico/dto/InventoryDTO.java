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
    private boolean isDeleted;
    private LocalDateTime deletedAt;



    //Getters & Setters
    
    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

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
