package com.pahana.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pahana.model.User;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
    	this.connection = DBConnectionFactory.getConnection();
    }

    public User authenticate(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            return user;
        }
        return null;
    }
    
    public void addUser(User user) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "UPDATE user SET username=?, password=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getId());
        statement.executeUpdate();
    }

    public void deleteUser(int id) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "DELETE FROM user WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
