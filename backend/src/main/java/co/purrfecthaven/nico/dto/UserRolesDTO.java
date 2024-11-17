package co.purrfecthaven.nico.dto;

/**
 * UserRolesDTO
 */
public class UserRolesDTO {

    private int userRoleId;
    private int userId;
    private int roleId;

    //Getters & Setters
    
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
