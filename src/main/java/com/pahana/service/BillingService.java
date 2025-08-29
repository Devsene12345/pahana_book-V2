package com.pahana.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pahana.model.Billing;
import com.pahana.DAO.BillingDAO;


public class BillingService {
    private BillingDAO billingDAO;

    public BillingService() {
        this.billingDAO = new BillingDAO();
    }

    public void createBilling(Billing billing) throws Exception {
        billingDAO.insertBilling(billing);
    }
}
