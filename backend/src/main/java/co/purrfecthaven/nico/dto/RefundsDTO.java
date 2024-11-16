package co.purrfecthaven.nico.dto;
import java.util.Date;
import java.math.BigDecimal;
/**
 * RefundsDTO
 */
public class RefundsDTO {

    private int refundId;
    private int paymentId;
    private BigDecimal amount;
    private Date refundDate;
    private String reason;
}
