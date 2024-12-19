<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Product JSP</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<% 
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    String msg = (String) request.getAttribute("msg"); // Corrected attribute name
        out.println(msg);
%>
<br>
<a href="product.html">Add Product</a>
<br>
<a href="view">View All Products</a>
<br>
<a href="logout">Logout</a>
</body>
</html>
