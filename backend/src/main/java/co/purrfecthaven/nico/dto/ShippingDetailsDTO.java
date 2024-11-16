package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ShippingDetailsDTO
 */
public class ShippingDetailsDTO {
    private int shippingId;
    private int orderId;
    private String providerName;
    private String shippingAddress;
    private Date shippingDate;
    private Date deliveryDate;
    private String status;
    
}
