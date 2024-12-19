<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h5>Authentication Successful...</h5>
<div>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Welcome Admin:"+ab.getfName()+"<br>");
%>
<p>
<a href="product.html">Add Product</a><br>
<a href="view">ViewAll Products</a><br>
<a href="logout" style="background-image: linear-gradient(to right, rgba(255,0,0,0), rgba(83, 136, 219));">Logout</a>
</p></div>
</body>
</html>