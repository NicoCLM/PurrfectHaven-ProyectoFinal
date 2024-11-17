package co.purrfecthaven.nico.dto;

/**
 * RolesDTO
 */
public class RolesDTO {
    private int roleId;
    private String roleName;
    private String description;

    //Getters & Setters
    
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
