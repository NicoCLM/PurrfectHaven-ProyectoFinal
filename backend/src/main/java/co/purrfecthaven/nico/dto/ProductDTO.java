package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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


    //Getters & Setters
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
