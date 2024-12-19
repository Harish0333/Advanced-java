<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddProduct Jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
out.println(msg);
%>
<a href="product.html">AddProduct</a>
<a href="view">ViewAllProducts</a>
<a href="logout">Logout</a>
</body>
</html>