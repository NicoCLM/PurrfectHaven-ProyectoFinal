package co.purrfecthaven.nico.model;
import java.util.Date;
import java.math.BigDecimal;
/**
 * Refunds
 */
public class Refunds {

    private int refundId;
    private int paymentId;
    private BigDecimal amount;
    private Date refundDate;
    private String reason;
}
