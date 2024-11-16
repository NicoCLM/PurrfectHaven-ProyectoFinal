package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.util.Date;
/**
 * PaymentsDTO
 */
public class PaymentsDTO {
    private int paymentId;
    private int orderId;
    private BigDecimal amount;
    private int paymentMethod;
    private Date paymentDate;
}
