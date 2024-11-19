package co.purrfecthaven.nico.dto;

import java.time.LocalDateTime;

/**
 * CategoryDTO
 */
public class CategoryDTO {
    private int categoryId;
    private String name;
    private String description;
    private boolean isDeleted;
    private LocalDateTime deletedAt;


    //Getters & Setters
    
    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getCategoryId() {
        return this.categoryId;
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

}
