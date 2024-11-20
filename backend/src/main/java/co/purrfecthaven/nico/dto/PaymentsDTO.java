package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
/**
 * PaymentsDTO
 */
public class PaymentsDTO {
    private int paymentId;
    private int orderId;
    private BigDecimal amount;
    private String paymentMethods;

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

    public String getPaymentMethods() {
        return this.paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }


}
