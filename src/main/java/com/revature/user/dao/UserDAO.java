package com.revature.user.dao;

import com.revature.user.common.ConnectionFactory;
import com.revature.user.users.ErsUsers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// DAO = Data Access Object
public class UserDAO {

    private String ErsUsers;

    public List<com.revature.user.users.ErsUsers> getAllErsUsers() {
        String sql = "select * " +
                     "from ers_users " +
                     "join ers_user_roles " +
                     "on ers_users.role_id = ers_user_roles.role_id ";


        List<ErsUsers> allErsUsers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                ErsUsers ersUser = new ErsUsers();
                ersUser.setUserId(rs.getString("user_id"));
                ersUser.setGivenName(rs.getString("given_name"));
                ersUser.setSurname(rs.getString("surname"));
                ersUser.setEmail(rs.getString("email"));
                ersUser.setUsername(rs.getString("username"));
                ersUser.setPassword("***********"); // done for security purposes
                ersUser.setRoleId(rs.getString("role_id"));
                allErsUsers.add(ersUser);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }
        return allErsUsers;
    }

    public String findErsUsersByUsernameAndPassword(String username, String Password){
        String sql = "SELECT ers_users.id, ers_users.given_name, ers_users.surname, ers_users.email, ers_users.username, ers_user.role_id, ers_users_role.role " +
                "FROM ers_users" +
                "JOIN ers_user_roles" +
                "ON ers_users.role_id = ers_user_roles.id";


        return ErsUsers;
    }


    public String save(ErsUsers user) {
        String sql = "INSERT INTO ers_users (user_id, given_name, surname, email, username, password, role_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";


        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});
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




