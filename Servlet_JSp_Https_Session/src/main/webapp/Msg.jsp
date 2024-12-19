<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
out.println(msg);
%>
<%@include file="home.html"%>

</body>
</html>