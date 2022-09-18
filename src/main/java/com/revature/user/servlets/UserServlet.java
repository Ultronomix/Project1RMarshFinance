package com.revature.user.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.user.dao.UserDAO;
import com.revature.user.service.UserService;
import com.revature.user.users.ErsUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {


    private  UserDAO userDAO;
    private  UserService userService;

    private ObjectMapper jsonMapper;

    public UserServlet(UserDAO userDAO){

    this.userDAO = userDAO;
    }

    public UserServlet(UserService userService, ObjectMapper jsonMapper) {

        this.userService = userService;
        this.jsonMapper = jsonMapper;

    }

    public void AuthServlet(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        resp.setContentType("application/json");
        List<ErsUsers> allErsUsers = userDAO.getAllErsUsers();
        resp.getWriter().write(jsonMapper.writeValueAsString(allErsUsers));


    }





}
