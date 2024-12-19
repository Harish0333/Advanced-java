<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login Jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h5>Authentication Successful...</h5>
<div>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("Welcome Customer:"+cb.getfName()+"<br>");
%>
<p>
<a href="profile">View Profile</a><br>
<a href="view">View Products</a><br>
<a href="logout" style="background-image: linear-gradient(to right, rgba(255,0,0,0), rgba(83, 136, 219));">Logout</a>
</p></div>
</body>
</html>