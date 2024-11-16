package co.purrfecthaven.nico.dto;
import java.util.Date;
/**
 * PasswordResetsDTO
 */
public class PasswordResetsDTO {

    private int resetId;
    private int userId;
    private String resetToken;
    private Date tokenExpiry;
    private Date resetDate;
}
