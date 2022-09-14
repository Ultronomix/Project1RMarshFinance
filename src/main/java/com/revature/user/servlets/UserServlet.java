package com.revature.user.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.user.dao.UserDAO;
import com.revature.user.users.ErsUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {


    private final UserDAO userDAO;

    public UserServlet(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        resp.setContentType("application/json");
        List<ErsUsers> allErsUsers = userDAO.getAllErsUsers();
        resp.getWriter().write(jsonMapper.writeValueAsString(allErsUsers));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO implement registration logic
        resp.getWriter().write("POST to /users works");
    }


}