package co.purrfecthaven.nico.model;
import java.util.Date;
import java.math.BigDecimal;
/**
 * Product
 */
public class Product {
    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String imageUrl;
    private int categoryId;
    private Date dateCreated;
}
