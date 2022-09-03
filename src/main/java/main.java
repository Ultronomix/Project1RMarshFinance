
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;



public class main {

    public static void main(String[] args){

        String dbUrl ="jdbc:postgresql://database-1.ceafvrzxrzy2.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=main";
        String dbUsername ="postgres";
        String dbPassword ="Fayejones0813";

        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            if (conn != null) {
                System.out.println("Connection Successful");
            }

        }
        catch (SQLException e){
            System.out.println("Could not read from properties file");
        }


        catch (ClassNotFoundException e) {
            System.out.println("Could not load PostgreSQL JDBC driver");
        }


     new WelcomeScreen();


    }
}

