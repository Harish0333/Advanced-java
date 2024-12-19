<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile Jsp</title>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body >
<%
String fName = (String)request.getAttribute("fname");
String msg = (String)request.getAttribute("msg");
out.println("Page belongs to : "+fName+"<br>");
out.println(msg);
%>
<a href="view">ViewProfile</a>
<a href="logout">Logout</a>

</body>
</html>