package com.pahana.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pahana.service.CustomerService;
import com.pahana.model.Customer;
import com.pahana.DAO.DBConnectionFactory;


@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        try (Connection con = DBConnectionFactory.getConnection()) {
            CustomerService service = new CustomerService(con);
            
            if ("register".equals(action)) {
                request.getRequestDispatcher("CustomerRegister.jsp").forward(request, response);
            }
            
            

            if ("list".equals(action)) {
                List<Customer> customers = service.getAllCustomers();
                request.setAttribute("customerList", customers);
                request.getRequestDispatcher("list-customers.jsp").forward(request, response);
                return;
            }
            if ("dashboard".equals(action)) {
                List<Customer> customers = service.getAllCustomers();
                request.setAttribute("customerList", customers);
                request.getRequestDispatcher("adminDashBoard.jsp").forward(request, response);
                return;
            }

            if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = service.getCustomerById(id);
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("edit-customer.jsp").forward(request, response);
                return;
            }

            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                service.deleteCustomer(id);
                response.sendRedirect("customer?action=list");
                return;
            }

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
        } catch (Exception e) {
            throw new ServletException(e);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");

	        try (Connection con = DBConnectionFactory.getConnection()) {
	            CustomerService service = new CustomerService(con);

	            if ("add".equals(action)) {
	                Customer c = new Customer();
	                c.setAccount_number(request.getParameter("account_number"));
	                c.setName(request.getParameter("name"));
	                c.setAddress(request.getParameter("address"));
	                c.setEmail(request.getParameter("email"));
	                c.setPhone(request.getParameter("phone"));
	                c.setPassword(request.getParameter("password"));
	                service.addCustomer(c);
	                response.sendRedirect("customer?action=list");
	                return;

	            } else if ("update".equals(action)) {
	                Customer c = new Customer();
	                c.setId(Integer.parseInt(request.getParameter("id")));
	                c.setAccount_number(request.getParameter("account_number"));
	                c.setName(request.getParameter("name"));
	                c.setAddress(request.getParameter("address"));
	                c.setEmail(request.getParameter("email"));
	                c.setPhone(request.getParameter("phone"));
	                c.setPassword(request.getParameter("password"));
	                service.updateCustomer(c);
	                response.sendRedirect("customer?action=list");
	                return;
	            }
	            
	         // ✅ Redirect to login or success page after registration
	            response.sendRedirect("UserLogin.jsp");

	        } catch (Exception e) {
	            throw new ServletException(e);
	        }
	    }
	}


