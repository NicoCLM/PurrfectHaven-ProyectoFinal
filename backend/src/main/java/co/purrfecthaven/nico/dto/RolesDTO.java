package co.purrfecthaven.nico.dto;

import java.time.LocalDateTime;


/**
 * RolesDTO
 */
public class RolesDTO {
    private int roleId;
    private String roleName;
    private String description;

    private boolean isDeleted;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    //Getters & Setters
    
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

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
    
    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
