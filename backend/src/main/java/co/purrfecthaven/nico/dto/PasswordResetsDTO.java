package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;
/**
 * PasswordResetsDTO
 */
public class PasswordResetsDTO {

    private int resetId;
    private int userId;
    private String resetToken;

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

}
