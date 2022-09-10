import com.revature.taskmaster.auth.AuthService;
import com.revature.taskmaster.auth.AuthServlet;
import com.revature.taskmaster.users.UserDAO;
import com.revature.taskmaster.users.UserServlet;

import com.revature.user.AuthServlet;
import com.revature.user.ConnectionFactory;
import com.revature.user.UserServlet;

import java.sql.*;


public class Main {

        public static void main(String[] args) throws LifecycleException {
            String docBase = System.getProperty("java.io.tmpdir");
            Tomcat webServer = new Tomcat();

            // Web server base configurations
            webServer.setBaseDir(docBase);
            webServer.setPort(5000); // defaults to 8080, but we can set it to whatever port we want (as long as its open)
            webServer.getConnector(); // formality, required in order for the server to receive requests

            // App component instantiation
            UserDAO userDAO = new UserDAO();
            UserServlet userServlet = new UserServlet(userDAO);
            AuthServlet authServlet = new AuthServlet(userDAO);

            // Web server context and servlet configurations
            final String rootContext = "/taskmaster";
            webServer.addContext(rootContext, docBase);
            webServer.addServlet(rootContext, "UserServlet", userServlet).addMapping("/users");
            webServer.addServlet(rootContext, "AuthServlet", authServlet).addMapping("/auth");

            // Starting and awaiting web requests
            webServer.start();
            webServer.getServer().await();


            UserDAO userDAO = new UserDAO();
            AuthService authService = new AuthService(userDAO);
            UserServlet userServlet = new UserServlet(userDAO);
            AuthServlet authServlet = new AuthServlet(authService);

            // Web server context and servlet configurations
            final String rootContext = "/taskmaster";














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

