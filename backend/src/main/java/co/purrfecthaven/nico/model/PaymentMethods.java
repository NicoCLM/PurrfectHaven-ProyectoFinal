package co.purrfecthaven.nico.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * PaymentMethods
 */

@Entity
@Table(name = "payment_methods")
public class PaymentMethods {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private int methodId;

    @NotNull
    private String methodName;

    @NotNull
    private LocalDateTime createdAt;

    //Getters & Setters
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getMethodId() {
        return this.methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
}
