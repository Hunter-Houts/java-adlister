package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),config.getUser(),config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findByEmail(String email) {
//        String searchTerm = request.getParameter();
        String sql = "SELECT * FROM Users WHERE email LIKE  ?";
        String searchWithWildCards = "%" + email + "%";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,searchWithWildCards);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new User(rs.getLong("id"),rs.getString("email"),rs.getString("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO Users(email, password) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();


            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}