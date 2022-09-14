package com.revature.user.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


// Implements the Factory and Singleton design patterns
public class ConnectionFactory{

    private static ConnectionFactory conn;


    private Properties dbProps = new Properties();

    public ConnectionFactory() {
        try {
            Class.forName("org.postgresql.Driver");
            dbProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            //dbProps.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            // TODO replace RuntimeException with a custom exception
            throw new RuntimeException("Could not read from properties file.");
        } catch (ClassNotFoundException e) {
            // TODO replace RuntimeException with a custom exception
            throw new RuntimeException("Failed to load PostgreSQL JDBC driver.");
        }
    }

    public static ConnectionFactory getInstance() {
        if (conn == null) {
            conn = new ConnectionFactory();
        }
        return conn;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbProps.getProperty("dbUrl"), dbProps.getProperty("dbUsername"), dbProps.getProperty("dbPassword"));
    }

}
