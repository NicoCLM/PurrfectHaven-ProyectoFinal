package co.purrfecthaven.nico.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
/**
 * LoginAttempts
 */
@Entity
@Table(name = "login_attempts")
public class LoginAttempts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private LocalDateTime attemptDate;

    @NotNull
    private boolean successful;
    
    @NotNull
    private LocalDateTime createdAt;

    //Getters & Setters
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public int getAttemptId() {
        return this.attemptId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getAttemptDate() {
        return this.attemptDate;
    }

    public void setAttemptLocalDateTime(LocalDateTime attemptDate) {
        this.attemptDate = attemptDate;
    }

    public boolean getSuccessful() {
        return this.successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    
}
