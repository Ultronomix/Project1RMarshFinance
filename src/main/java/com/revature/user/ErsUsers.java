package com.revature.user;

import java.util.Objects;

public class ErsUsers {

    public String userId;
    public String username;
    public String email;
    public String password;
    public String givenName;
    public String surname;
    public boolean isActive;
    public String roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsUsers ers_users = (ErsUsers) o;
        return isActive == ers_users.isActive && Objects.equals(userId, ers_users.userId) && username.equals(ers_users.username) && email.equals(ers_users.email) && password.equals(ers_users.password) && givenName.equals(ers_users.givenName) && surname.equals(ers_users.surname) && Objects.equals(roleId, ers_users.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, givenName, surname, isActive, roleId);
    }

    @Override
    public String toString() {
        return "Ers_Users{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive=" + isActive +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
