package co.purrfecthaven.nico.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * UserRoles
 */

@Entity
@Table(name = "user_roles")
public class UserRoles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int userRoleId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;
 
    @NotNull
    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    
}

