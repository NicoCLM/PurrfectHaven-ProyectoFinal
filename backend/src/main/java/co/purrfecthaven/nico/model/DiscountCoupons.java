package co.purrfecthaven.nico.model;
import java.math.BigDecimal;
import java.util.Date;
/**
 * DiscountCouponsDTO
 */
public class DiscountCoupons {
    private int couponId;
    private String couponCode;
    private BigDecimal discountPercentage;
    private Date expirationDate;
    private boolean isActive;
    
}
