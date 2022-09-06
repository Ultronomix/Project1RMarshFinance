
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;



public class main {

    public static void main(String[] args){


        try {

            Properties dbProps = new Properties();
            dbProps.load(new FileReader("src/main/resources/application.properties"));

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(dbProps.getProperty("db-url"), dbProps.getProperty("db-username"), dbProps.getProperty("db-password"));
            if (conn != null) {
                System.out.println("Connection Successful");
            }

        }

        catch (IOException e){
            System.err.println("Could not read from properties file");
            e.printStackTrace();

        }
        catch (SQLException e){
            System.out.println("Could not read from properties file");
            e.printStackTrace();
        }


        catch (ClassNotFoundException e) {
            System.out.println("Could not load Postgresql JDBC driver");
        }


     new WelcomeScreen();


    }
}

