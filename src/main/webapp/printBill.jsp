<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Print Bill</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body onload="window.print();">
<h2>Print Preview</h2>
<p>Customer ID: ${param.customerId}</p>
<p>Units Consumed: ${param.unitsConsumed}</p>
<p>Total Amount: Rs. ${param.totalAmount}</p>
</body>
</html>
