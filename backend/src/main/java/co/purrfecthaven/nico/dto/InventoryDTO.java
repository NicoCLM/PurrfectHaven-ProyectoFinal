package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;

/**
 * InventoryDTO
 */
public class InventoryDTO {

    private int inventoryId;
    private int productId;
    private int stockLevel;

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



}
