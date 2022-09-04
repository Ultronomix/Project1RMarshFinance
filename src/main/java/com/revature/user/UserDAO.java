package com.revature.user;

import org.postgresql.core.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    private List<com.revature.user.ErsUsers> ErsUsers;

    public List<ErsUsers> getAllErsUsers() {

        String sql = "SELECT" +
                      "au.user_id, au.usernsme, au.email, au.password, au.given_name, is_active, role_id " +
                      "FROM ers_Users au " +
                      "JOIN ErsUserRoles ur ";
        
        return ErsUsers;

         try (Connection conn = ConnectionFactory.getInstance().getConnection()){

        }catch (SQLException e) {

             System.out.println("Something went wrong while communicating to database");
         }

    }
}
