package co.purrfecthaven.nico.dto;
import java.util.Date;
import java.math.BigDecimal;
/**
 * ProductDTO
 */
public class ProductDTO {
    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String imageUrl;
    private int categoryId;
    private Date dateCreated;
}
