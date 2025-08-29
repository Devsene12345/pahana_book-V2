package com.pahana.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pahana.DAO.DBConnectionFactory;
import com.pahana.service.ProductService;
import com.pahana.model.Product;


@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        try (Connection conn = DBConnectionFactory.getConnection()) {
            ProductService service = new ProductService(conn);

            if ("list".equals(action)) {
                request.setAttribute("products", service.getAll());
                request.getRequestDispatcher("ListProducts.jsp").forward(request, response);
                return;
            }
            
            if ("edit".equals(action)) {
                int productId = Integer.parseInt(request.getParameter("product_id"));
                Product product = service.getProductById(productId);
                request.setAttribute("product", product);
                request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                return;
            }

            if ("delete".equals(action)) {
                int productId = Integer.parseInt(request.getParameter("product_id"));
                service.deleteProduct(productId);
                response.sendRedirect("product?action=list");
                return;
            }

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        try (Connection conn = DBConnectionFactory.getConnection()) {
            ProductService service = new ProductService(conn);

            if ("add".equals(action)) {
                Product p = new Product();
                p.setName(request.getParameter("name"));
                p.setDescription(request.getParameter("description"));
                p.setPrice(Double.parseDouble(request.getParameter("price")));
                p.setStock(Integer.parseInt(request.getParameter("stock")));
                service.addProduct(p);
                response.sendRedirect("product?action=list");
                return;
            }

            if ("update".equals(action)) {
                Product p = new Product();
                p.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
                p.setName(request.getParameter("name"));
                p.setDescription(request.getParameter("description"));
                p.setPrice(Double.parseDouble(request.getParameter("price")));
                p.setStock(Integer.parseInt(request.getParameter("stock")));
                service.updateProduct(p);
                response.sendRedirect("product?action=list");
                return;
            }

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
}
	


