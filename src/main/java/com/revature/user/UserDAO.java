package com.revature.user;

import org.apache.catalina.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// DAO = Data Access Object
public class UserDAO {

    private String ErsUsers;

    public List<ErsUsers> getAllUsers() {
        String sql = "SELECT ers_users.user_id, ers_users.given_name, ers_users.surname, ers_users.email, ers_users.username, ers_users.role_id, ers_user_roles.role_id " +
                "FROM ers_users " +
                "JOIN ers_user_roles " +
                "ON ers_users.role_id = ers_users_role.id";


        List<ErsUsers> allUsers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // JDBC Statement objects are vulnerable to SQL injection
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                ErsUsers user = new ErsUsers();
                user.setUserId(rs.getString("user_id"));
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

    public Optional<ErsUsers> findErsUsersByUsernameAndPassword(String username, String Password){
        String sql = "SELECT au.id, au.given_name, au.surname, au.email, au.username, au.role_id, ur.role " +
                "FROM app_users au " +
                "JOIN user_roles ur " +
                "ON au.role_id = ur.id";


        return null;
    }


    public String save(ErsUsers user) {
        String sql = "INSERT INTO app_users (user_id, given_name, surname, email, username, password, role_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";


        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"UserId"});
            pstmt.setString(1, user.getGivenName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            user.setUserId(rs.getString("user_Id"));


        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }


        return ErsUsers;
    }



}




