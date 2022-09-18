package com.revature.user.dao;

import com.revature.user.common.ConnectionFactory;
import com.revature.user.exceptions.DataSourceException;
import com.revature.user.users.ErsUserRoles;
import com.revature.user.users.ErsUsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// DAO = Data Access Object
public class UserDAO {

    private final String baseSelect = "Select ers_users.user_id, ers_users.given_name, ers_users.surname, ers_users.email, ers_users.user_name, ers_users.role_id, ers_user_roles.role_id " +
                                 "From ers_users " +
                                 "Join ers_user_roles " +
                                 "ON ers_users.role_id = ers_users_role.role_id";

    public List<ErsUsers> getAllErsUsers() {


        List<ErsUsers> allErsUsers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(baseSelect);

            allErsUsers = mapResultSet(rs);

        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }
        return allErsUsers;
    }

    public Optional<ErsUsers> findUserByUsernameAndPassword(String username, String password) {
        String sql = baseSelect + "WHERE ers_users.username = ? AND ers_users.password = ?";
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // JDBC Statement objects are vulnerable to SQL injection
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
            // TODO log this exception
            throw new DataSourceException(e);
        }

    }

    public String save(ErsUsers user) {
        String sql = "INSERT INTO _users (given_name, surname, email, username, password, role_id) " +
                "VALUES (?, ?, ?, ?, ?, '5a2e0415-ee08-440f-ab8a-778b37ff6874')";
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
            pstmt.setString(1, user.getGivenName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            user.setUserId(rs.getString("id"));
        } catch (SQLException e) {
            log("ERROR", e.getMessage());
        }
        log("INFO", "Successfully persisted new used with id: " + user.getUserId());
        return user.getUserId();
    }
    private List<ErsUsers> mapResultSet(ResultSet rs) throws SQLException {
        List<ErsUsers> users = new ArrayList<>();
        while (rs.next()) {
            ErsUsers user = new ErsUsers();
            user.setUserId(rs.getString("id"));
            user.setGivenName(rs.getString("given_name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getString("role_id"));
            users.add(user);
        }
        return users;
    }
    public void log(String level, String message) {
        try {
            File logFile = new File("logs/app.log");
            logFile.createNewFile();
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFile));
            logWriter.write(String.format("[%s] at %s logged: [%s] %s\n", Thread.currentThread().getName(), LocalDate.now(), level.toUpperCase(), message));
            logWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}




