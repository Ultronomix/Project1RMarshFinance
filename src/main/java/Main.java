

import com.revature.user.ConnectionFactory;

import java.sql.*;


public class Main {

        public static void main(String[] args) {

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

           if (conn != null) {
               System.out.println("Connection established");
           }

        } catch (SQLException e){
            System.out.println("There was a problem communicating with the database");
            e.printStackTrace();
        }












    }
}

