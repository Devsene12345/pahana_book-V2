package com.pahana.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pahana.model.Product;


public class ProductDAO {
    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) throws SQLException {
    	String sql = "INSERT INTO product (name, description, price, stock) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DBConnectionFactory.getConnection(); // ✅ Fresh connection
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStock());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int id) throws SQLException {
        if (connection == null) throw new SQLException("Database connection is null");
        String sql = "SELECT product_id, name, description, price, stock FROM product WHERE product_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setProduct_id(rs.getInt("product_id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setPrice(rs.getDouble("price"));
                    p.setStock(rs.getInt("stock"));
                    return p;
                }
                return null;
            }
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (
            Connection conn = DBConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }


    public void updateProduct(Product product) throws SQLException {
    	String sql = "UPDATE product SET name = ?, description = ?, price = ?, stock = ? WHERE product_id = ?";

        try (
            Connection conn = DBConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ) {
        	statement.setString(1, product.getName());
        	statement.setString(2, product.getDescription());
        	statement.setDouble(3, product.getPrice());
        	statement.setInt(4, product.getStock());
        	statement.setInt(5, product.getProduct_id());

        	statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) throws SQLException {
    	String sql = "DELETE FROM product WHERE product_id = ?";

        try (
            Connection conn = DBConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ) {
        	statement.setInt(1, id);
        	statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

