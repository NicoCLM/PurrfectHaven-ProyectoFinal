package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderDetailsDTO
 */
public class OrderDetailsDTO {
    private int orderDetailsId;
    private int orderId;
    private int productId;
    private int quantity;
    private BigDecimal price;
    
    //Getters & Setters
    
    public int getOrderDetailsId() {
        return this.orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
