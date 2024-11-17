package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * PaymentsDTO
 */
public class PaymentsDTO {
    private int paymentId;
    private int orderId;
    private BigDecimal amount;
    private int paymentMethod;
    private Timestamp paymentDate;

    //Getters & Setters
    
    public int getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Timestamp getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

}
