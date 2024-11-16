package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.util.Date;
/**
 * Payments
 */
public class Payments {
    private int paymentId;
    private int orderId;
    private BigDecimal amount;
    private int paymentMethod;
    private Date paymentDate;
}
