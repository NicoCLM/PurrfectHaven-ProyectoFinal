package co.purrfecthaven.nico.dto;

import java.time.LocalDateTime;

/**
 * UserRolesDTO
 */
public class UserRolesDTO {

    private int userRoleId;
    private int userId;
    private int roleId;
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

    public int getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
