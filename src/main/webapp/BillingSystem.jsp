<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Billing Result</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Billing Summary</h2>
    <%
        String msg = (String) request.getAttribute("message");
        Double total = (Double) request.getAttribute("totalAmount");
    %>
    <div class="alert alert-success"><%= msg %></div>
    <p><strong>Total Amount:</strong> Rs. <%= total %></p>
</div>
</body>
</html>
