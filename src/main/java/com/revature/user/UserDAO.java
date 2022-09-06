package com.revature.user;

import org.postgresql.core.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO {

    private List<com.revature.user.ErsUsers> ErsUsers;

   public List<ErsUsers> getAllErsUsers() {

       String sql = "SELECT" +
                    "au.user_id, au.usernsme, au.email, au.password, au.given_name, au.is_active, au.role_id " +
                    "FROM ers_Users au " +
                    "JOIN ers_user_roles ur ";


       assert ConnectionFactory.getInstance() != null;

         try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            Statement stmt = conn.createStatement();

             ResultSet resultSet = stmt.excuteQuery(sql);

        }catch (SQLException e) {

            System.out.println("Something went wrong while communicating to database");
         }


       return ErsUsers;
   }


}
