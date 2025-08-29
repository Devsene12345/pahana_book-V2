<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error - Pahana Edu</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8d7da;
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .error-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 600px;
            text-align: center;
        }
        .error-icon {
            font-size: 50px;
            color: #dc3545;
        }
        .error-details {
            margin-top: 20px;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="error-icon">
        ❌
    </div>
    <h2 class="text-danger">Oops! Something went wrong.</h2>
    <p class="text-muted">An unexpected error occurred while processing your request.</p>

    <div class="error-details bg-light p-3 rounded">
        <strong>Error Message:</strong><br/>
        <pre><%= exception != null ? exception.getMessage() : "Unknown error." %></pre>
    </div>

    <a href="index.jsp" class="btn btn-danger mt-4">Back to Home</a>
</div>
</body>
</html>
