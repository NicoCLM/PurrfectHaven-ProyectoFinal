package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * OrderDetails
 */

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int orderDetailsId;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @NotNull
    private int productId;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal price;

    //Getters & Setters

    public int getOrderDetailsId() {
        return this.orderDetailsId;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
