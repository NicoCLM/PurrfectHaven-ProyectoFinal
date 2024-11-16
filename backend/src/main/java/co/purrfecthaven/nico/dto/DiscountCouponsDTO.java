package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.util.Date;
/**
 * DiscountCouponsDTO
 */
public class DiscountCouponsDTO {
    private int couponId;
    private String couponCode;
    private BigDecimal discountPercentage;
    private Date expirationDate;
    private boolean isActive;
    
}
