
import com.revature.user.ConnectionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;



public class main {

    public static void main(String[] args){


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

