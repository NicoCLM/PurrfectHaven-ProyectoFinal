package co.purrfecthaven.nico.model;
import java.util.Date;
/**
 * PasswordResets
 */
public class PasswordResets {

    private int resetId;
    private int userId;
    private String resetToken;
    private Date tokenExpiry;
    private Date resetDate;
}
