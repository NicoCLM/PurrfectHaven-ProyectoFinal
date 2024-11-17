package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;
/**
 * PasswordResetsDTO
 */
public class PasswordResetsDTO {

    private int resetId;
    private int userId;
    private String resetToken;
    private LocalDateTime tokenExpiry;
    private LocalDateTime resetDate;

    //Getters & Setters
    
    public int getResetId() {
        return this.resetId;
    }

    public void setResetId(int resetId) {
        this.resetId = resetId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getResetToken() {
        return this.resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getTokenExpiry() {
        return this.tokenExpiry;
    }

    public void setgetTokenExpiry(LocalDateTime tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public LocalDateTime getResetDate() {
        return this.resetDate;
    }

    public void setResetDate(LocalDateTime resetDate) {
        this.resetDate = resetDate;
    }
}
