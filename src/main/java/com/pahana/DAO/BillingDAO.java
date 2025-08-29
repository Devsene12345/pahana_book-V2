package com.pahana.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.pahana.model.Billing;

public class BillingDAO {

    public void insertBilling(Billing billing) {
        String sql = "INSERT INTO billing (customer_id, units_consumed, total_amount) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

        	statement.setInt(1, billing.getCustomer_id());
        	statement.setDouble(2, billing.getUnits_consumed());
        	statement.setDouble(3, billing.getTotal_amount());
        	statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Billing> getAllBillings() {
        List<Billing> billingList = new ArrayList<>();
        String sql = "SELECT * FROM billing";
        try (Connection conn = DBConnectionFactory.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Billing billing = new Billing();
                billing.setBilling_id(rs.getInt("billing_id"));
                billing.setCustomer_id(rs.getInt("customer_id"));
                billing.setUnits_consumed(rs.getDouble("units_consumed"));
                billing.setTotal_amount(rs.getDouble("total_amount"));
                billingList.add(billing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billingList;
    }
}

