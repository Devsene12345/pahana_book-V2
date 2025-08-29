package com.pahana.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pahana.model.Billing;
import com.pahana.service.BillingService;


@WebServlet("/BillingController")
public class BillingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillingService billingService;
   
    
	@Override
    public void init() throws ServletException {
        billingService = new BillingService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            double unitsConsumed = Double.parseDouble(request.getParameter("unitsConsumed"));
            double rate = 20.0;
            double total = unitsConsumed * rate;

            Billing billing = new Billing();
            billing.setCustomer_id(customerId);
            billing.setUnits_consumed(unitsConsumed);
            billing.setTotal_amount(total);

            billingService.createBilling(billing);

            request.setAttribute("message", "Bill generated successfully!");
            request.setAttribute("totalAmount", total);
            request.getRequestDispatcher("BillingSystem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Billing error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

}
