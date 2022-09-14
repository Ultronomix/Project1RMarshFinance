

//import com.revature.user.common.ConnectionFactory;
import com.revature.user.dao.UserDAO;
import com.revature.user.servlets.AuthServlet;
import com.revature.user.servlets.UserServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


public class Main {

        public static void main(String[] args) throws LifecycleException {

            String docBase = System.getProperty("java.io.tmpdir");
            Tomcat webServer = new Tomcat();

            webServer.setBaseDir(docBase);
            webServer.setPort(8081); // defaults to 8080, but we can set it to whatever port we want (as long as its open)
            webServer.getConnector(); // formality, required in order for the server to receive requests

            UserDAO userDAO = new UserDAO();
            UserServlet userServlet = new UserServlet(userDAO);
            AuthServlet authServlet = new AuthServlet(userDAO);


            webServer.addContext("/Project1RMarshFinance", docBase);
            webServer.addServlet("/Project1RMarshFinance","UserServlet", userServlet).addMapping("/ErsUsers");
            webServer.addServlet("Project1RMarshFinance","AuthServlet", authServlet).addMapping("/auth");


            webServer.start();
            webServer.getServer().await();
            System.out.println("Web Application Successfully Statred");


        }

}






















