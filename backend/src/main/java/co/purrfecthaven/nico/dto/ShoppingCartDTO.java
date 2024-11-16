package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.util.Date;
/**
 * ShoppingCartDTO
 */
public class ShoppingCartDTO {
    private int cartId;
    private int productId;
    private int userId;
    private int amount;
    private Date dateAdded;
    private String status;
}
