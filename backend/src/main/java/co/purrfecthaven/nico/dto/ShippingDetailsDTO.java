package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;

/**
 * ShippingDetailsDTO
 */
public class ShippingDetailsDTO {
    private int shippingId;
    private int orderId;
    private String providerName;
    private String shippingAddress;
    private LocalDateTime shippingDate;
    private LocalDateTime deliveryDate;
    private String status;
    


    //Getters & Setters
    
    public int getShippingId() {
        return this.shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }
    
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int  orderId) {
        this.orderId = orderId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }   

    public LocalDateTime getShippingDate() {
        return this.shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDateTime getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
