package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ShippingDetails
 */
public class ShippingDetails {
    private int shippingId;
    private int orderId;
    private String providerName;
    private String shippingAddress;
    private Date shippingDate;
    private Date deliveryDate;
    private String status;
    
}
