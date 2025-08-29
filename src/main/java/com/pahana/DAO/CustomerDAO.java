package com.pahana.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pahana.model.Customer;


public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
    	this.connection = DBConnectionFactory.getConnection();
    }

    public void addCustomer(Customer customer) throws SQLException {
    	if (connection == null) throw new SQLException("Database connection is null");
        String sql = "INSERT INTO customer (account_number, name, address, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getAccount_number());
        statement.setString(2, customer.getName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getEmail());
        statement.setString(5, customer.getPhone());
        statement.setString(6, customer.getPassword());
        statement.executeUpdate();
    }

    public List<Customer> getAllCustomers() throws SQLException {
    	if (connection == null) throw new SQLException("Database connection is null");
    	List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setAccount_number(rs.getString("account_number"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setEmail(rs.getString("email"));
            customer.setPhone(rs.getString("phone"));
            customer.setPassword(rs.getString("password"));
            customers.add(customer);
        }
        return customers;
    }

    public Customer getCustomerById(int id) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setAccount_number(rs.getString("account_number"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setEmail(rs.getString("email"));
            customer.setPhone(rs.getString("phone"));
            customer.setPassword(rs.getString("password"));
            return customer;
        }
        return null;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "UPDATE customer SET account_number=?, name=?, address=?, email=?, phone=?, password=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getAccount_number());
        statement.setString(2, customer.getName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getEmail());
        statement.setString(5, customer.getPhone());
        statement.setInt(6, customer.getId());
        statement.setString(7, customer.getPassword());
        statement.executeUpdate();
    }

    public void deleteCustomer(int id) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "DELETE FROM customer WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
