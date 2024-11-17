package co.purrfecthaven.nico.dto;
import java.time.LocalDateTime;
/**
 * LoginAttemptsDTO
 */
public class LoginAttemptsDTO {
    
    private int attemptId;
    private int userId;
    private LocalDateTime attemptDate;
    private boolean successful;

    //Getters & Setters
    
    public int getAttemptId() {
        return this.attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
