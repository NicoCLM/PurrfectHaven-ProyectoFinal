package co.purrfecthaven.nico.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ShoppingCartDTO
 */
public class ShoppingCartDTO {
    private int cartId;
    private int productId;
    private List<ProductDTO> products;
    private int userId;
    private int amount;
    private LocalDateTime dateAdded;
    private String status;

    //Getters & Setters

    
    
    public int getCartId() {
        return this.cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }   

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }   

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }   

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }   

    public LocalDateTime getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
