<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.pahana.model.Customer" %>
<%
    List<Customer> customerList = (List<Customer>) request.getAttribute("customers");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List • Pahana Edu</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        :root {
            --brand: #0d6efd;
            --brand-alt: #6610f2;
            --bg: #f5f7fb;
            --card-bg: #ffffff;
            --text: #222;
        }

        body {
            background: var(--bg);
            color: var(--text);
        }

        .brand-nav {
            background: linear-gradient(135deg, var(--brand), var(--brand-alt));
        }

        .brand-nav .navbar-brand {
            font-weight: 700;
            letter-spacing: .2px;
        }

        .table-card {
            background: var(--card-bg);
            border: 1px solid rgba(0, 0, 0, .05);
            border-radius: 18px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, .08);
            margin: 56px auto;
            max-width: 960px;
            padding: 24px;
        }

        .table th {
            background-color: var(--brand);
            color: white;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark brand-nav">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">Pahana Edu</a>
        <div class="ms-auto d-flex gap-2">
            <a class="btn btn-light btn-sm" href="adminDashBoard.jsp">Home</a>
            <a class="btn btn-outline-light btn-sm" href="CustomerRegister.jsp">Add New Customer</a>
        </div>
    </div>
</nav>

<div class="container table-card">
    <h2 class="mb-4">Registered Customers</h2>

    <% if (customerList != null && !customerList.isEmpty()) { %>
        <div class="table-responsive">
            <table class="table table-bordered table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Account Number</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Customer c : customerList) { %>
                        <tr>
                            <td><%= c.getId() %></td>
                            <td><%= c.getAccount_number() %></td>
                            <td><%= c.getName() %></td>
                            <td><%= c.getAddress() %></td>
                            <td><%= c.getEmail() %></td>
                            <td><%= c.getPhone() %></td>
                            <td><%= c.getPassword() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    <% } else { %>
        <div class="alert alert-info">No customers found.</div>
    <% } %>
</div>

</body>
</html>
