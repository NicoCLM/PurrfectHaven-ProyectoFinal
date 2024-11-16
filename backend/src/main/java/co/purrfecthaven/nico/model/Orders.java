package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.util.Date;
/**
 * Orders
 */
public class Orders {
    private int orderId;
    private int userId;
    private BigDecimal total;
    private String status;
    private String address;
    private Date orderDate;
    
}
