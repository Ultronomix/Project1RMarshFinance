package com.revature.user.servlets;

import com.revature.user.exceptions.AuthenticationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.user.common.Credentials;
import com.revature.user.dao.UserDAO;
import com.revature.user.exceptions.DataSourceException;
import com.revature.user.exceptions.InvalidRequestException;
import com.revature.user.service.AuthService;
import com.revature.user.users.ErsUsers;
import com.revature.user.users.UserResponse;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class AuthServlet extends HttpServlet {

    //private static Logger logger = LogManager.getLogger(AuthServlet.class);

    private final AuthService authService;
    private final ObjectMapper jsonMapper;

    public AuthServlet(AuthService authService, ObjectMapper jsonMapper) {
        this.authService = authService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // logger.info("A POST request was received by /taskmaster/auth at {}", LocalDateTime.now());

        resp.setContentType("application/json");


        try {

            Credentials credentials = jsonMapper.readValue(req.getInputStream(), Credentials.class);
            UserResponse responseBody = authService.authenticate(credentials);
            resp.setStatus(200); // OK; general success; technically this is the default

            // Establishes an HTTP session that is implicitly attached to the response as a cookie
            // The web client will automatically attach this cookie to subsequent requests to the server
            //logger.info("Establishing user session for user: {}", responseBody.getUsername());
            HttpSession userSession = req.getSession();
            userSession.setAttribute("authUser", responseBody);

            resp.getWriter().write(jsonMapper.writeValueAsString(responseBody));

           // logger.info("POST request successfully processed at {}", LocalDateTime.now());

        } catch (InvalidRequestException | JsonMappingException e) {
          //  logger.warn("Error processing request at {}, error message: {}", LocalDateTime.now(), e.getMessage());
            resp.setStatus(400); // BAD REQUEST
        //    resp.getWriter().write(jsonMapper.writeValueAsString(new //ErrorResponse(400, e.getMessage())));
     //   } catch (AuthenticationException e) {
          //  logger.warn("Failed login at {}, error message: {}", LocalDateTime.now(), e.getMessage());
            resp.setStatus(401); // UNAUTHORIZED; typically sent back when login fails or if a protected endpoint is hit by an unauthenticated user
      //      resp.getWriter().write(jsonMapper.writeValueAsString(new ErrorResponse(401, e.getMessage())));
      //  } catch (DataSourceException e) {
     //     //  logger.error("A data source error occurred at {}, error message: {}", LocalDateTime.now(), e.getMessage());
       //     resp.setStatus(500); // INTERNAL SERVER ERROR; general error indicating a problem with the server
       //     resp.getWriter().write(jsonMapper.writeValueAsString(new ErrorResponse(500, e.getMessage())));
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate(); // this effectively "logs out" the requester by invalidating the session within the server
    }

}
