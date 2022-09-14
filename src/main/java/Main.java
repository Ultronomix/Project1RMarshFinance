

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
            webServer.setPort(8081);
            webServer.getConnector();

            UserDAO userDAO = new UserDAO();
            UserServlet userServlet = new UserServlet(userDAO);
            AuthServlet authServlet = new AuthServlet(userDAO);



            String rootContext = "/Project1RMarshFinance";

            webServer.addContext(rootContext, docBase);
            webServer.addServlet(rootContext,"UserServlet", userServlet).addMapping("/ErsUsers");
            webServer.addServlet(rootContext,"AuthServlet", authServlet).addMapping("/auth");


            webServer.start();
            webServer.getServer().await();
            System.out.println("Web Application Successfully Statred");


        }

}






















