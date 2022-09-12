package com.revature.user;

import com.revature.user.ErsUsers;
import com.revature.user.UserDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppContext {

    private static boolean appRunning;
    private BufferedReader consoleReader;

    public AppContext() {
        appRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startApp() {
        while (appRunning) {

            try {
                System.out.println("The App is Running, but will stop");
                appRunning = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void shutdown() {
        appRunning = false;
    }



}