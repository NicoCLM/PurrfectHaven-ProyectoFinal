package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
    private Timestamp shippingDate;

    @NotNull
    private Timestamp deliveryDate;

    @NotNull
    private String status;

    //Getters & Setters

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

    public Timestamp getShippingdate() {
        return this.shippingDate;
    }

    public void setShippingdate(Timestamp shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Timestamp getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
    
}
