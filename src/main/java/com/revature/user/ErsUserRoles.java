package com.revature.user;

import java.util.Objects;

public class ErsUserRoles {

    public String roleId;

    public String role;




    public void setRole(String role) {
        this.role = role;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErsUserRoles that)) return false;
        return Objects.equals(getRoleId(), that.getRoleId()) && Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(), getRole());
    }

    @Override
    public String toString() {
        return "ErsUserRoles{" +
                "roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
