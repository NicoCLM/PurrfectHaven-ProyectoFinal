package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
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
 * ShippingDetails
 */

@Entity
@Table(name = "shipping_details")
public class ShippingDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @NotNull
    private int shippingId;

    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Orders orders;

    @NotNull
    private String providerName;
    
    @NotNull
    private String shippingAddress;

    @NotNull
    private LocalDateTime shippingDate;

    @NotNull
    private LocalDateTime deliveryDate;

    @NotNull
    private String status;
    
    @NotNull
    private LocalDateTime createdAt;

    //Getters & Setters
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getShippingId() {
        return this.shippingId;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public LocalDateTime getShippingdate() {
        return this.shippingDate;
    }

    public void setShippingdate(LocalDateTime shippingDate) {
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
