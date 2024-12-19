<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Jsp Page</title>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body style="font-family:cursive;
	color:Darkblue;border-style: ridge;
	border-radius: 12px;height:150px;padding:11px;">
<%
UserBean ub = (UserBean)application.getAttribute("ubean");
out.println("Welcome User : "+ub.getfName()+"<br><br>");
%>
<a href="view">ViewProfile</a>&nbsp;&nbsp;
<a href="edit">EditProfile</a>&nbsp;&nbsp;
<a href="logout">Logout</a>
</body>
</html>