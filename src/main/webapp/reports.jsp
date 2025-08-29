<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports • Pahana Edu</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            padding: 30px;
        }

        .container {
            max-width: 960px;
            margin: auto;
            background-color: white;
            padding: 40px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #343a40;
        }

        .table th, .table td {
            vertical-align: middle;
        }

        .btn-print {
            float: right;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Billing Reports</h2>

    <!-- Print button -->
    <button class="btn btn-primary btn-print mb-3" onclick="window.print()">Print Report</button>

    <!-- Sample report table -->
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>Report ID</th>
                <th>Customer Name</th>
                <th>Date</th>
                <th>Total Amount</th>
                <th>View</th>
            </tr>
        </thead>
        <tbody>
            <!-- Example static rows - Replace with JSTL/Servlet logic -->
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="#" class="btn btn-sm btn-outline-info">Details</a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="#" class="btn btn-sm btn-outline-info">Details</a></td>
            </tr>
            <!-- Add dynamic rows here -->
        </tbody>
    </table>
</div>

<!-- Bootstrap JS (Optional for interactivity) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
