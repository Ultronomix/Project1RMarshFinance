package com.revature.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<ErsUsers> getAllUsers() {
        String sql = "SELECT au.id, au.given_name, au.surname, au.email, au.username, au.role_id, ur.role " +
                "FROM app_users au " +
                "JOIN user_roles ur " +
                "ON au.role_id = ur.id";
        List<ErsUsers> allUsers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // JDBC Statement objects are vulnerable to SQL injection
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ErsUsers user = new ErsUsers();
                user.setUserId(rs.getString("id"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword("***********"); // done for security purposes
                user.setRoleId(rs.getString("role_id"));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }
        return allUsers;
    }
    public String save(ErsUsers user) {
        String sql = "INSERT INTO app_users (given_name, surname, email, username, password, role_id) " +
                "VALUES (?, ?, ?, ?, ?, '5a2e0415-ee08-440f-ab8a-778b37ff6874')";
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
            pstmt.setString(1, user.getGivenName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            user.setUserId(rs.getString("id"));


        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }
        return user.getUserId();
    }
}



