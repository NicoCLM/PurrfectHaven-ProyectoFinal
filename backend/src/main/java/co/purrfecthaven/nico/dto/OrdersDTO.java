package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * OrdersDTO
 */
public class OrdersDTO {
    private int orderId;
    private int userId;
    private BigDecimal total;
    private String status;
    private String address;
    private LocalDateTime orderDate;
    
    //Getters & Setters
    
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
