package co.purrfecthaven.nico.dto;

import java.time.LocalDateTime;

/**
 * CategoryDTO
 */
public class CategoryDTO {
    private int categoryId;
    private String name;
    private String description;

    //Getters & Setters
    
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
