

//import com.revature.user.ConnectionFactory;
import com.revature.user.UserServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.sql.*;


public class Main {

        public static void main(String[] args) throws LifecycleException {

            String docBase = System.getProperty("java.io.tmpdir");
            Tomcat webServer = new Tomcat();

            // Web server base configurations
            webServer.setBaseDir(docBase);
            webServer.setPort(8081); // defaults to 8080, but we can set it to whatever port we want (as long as its open)
            webServer.getConnector(); // formality, required in order for the server to receive requests

            webServer.addContext("/Project1RMarshFinance", docBase);
            webServer.addServlet("/Project1RMarshFinance","UserServlet", new UserServlet()).addMapping("/ErsUsers");


            webServer.start();
            webServer.getServer().await();
            System.out.println("Web Application Successfully Statred");


        }

}






















