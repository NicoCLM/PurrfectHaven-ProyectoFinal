package co.purrfecthaven.nico.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
/**
 * Inventory
 */
@Entity
@Table(name="inventory")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int inventoryId;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @NotNull
    private int stockLevel;
    
    @NotNull
    private LocalDateTime lastUpdated;


    //Getters & Setters
    public int getInventoryId() {
        return this.inventoryId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProductId(Product product) {
        this.product = product; 
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
