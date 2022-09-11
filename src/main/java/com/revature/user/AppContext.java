package com.revature.user;

import com.revature.user.ErsUsers;
import com.revature.user.UserDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppContext {

    private static boolean appRunning;
   // private BufferedReader consoleReader;

    public AppContext() {
        appRunning = true;
      //  consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startApp() {
        while (appRunning) {
            try {
              //  System.out.println("The app is started, but will close immediately.");
                UserDAO userDAO = new UserDAO();
                ErsUsers loggedInUsed = userDAO.findUserByUsernameAndPassword("aanderson", "p4$$W0RD")
                        .orElseThrow(() -> new RuntimeException("No user found with the provided credentials"));

                System.out.println("Successfully logged in user: " + loggedInUsed);
                appRunning = false;
            } catch (Exception e) {
                e.printStackTrace();
                appRunning = false;
            }
        }
    }
    public static void shutdown() {
        appRunning = false;
    }
}