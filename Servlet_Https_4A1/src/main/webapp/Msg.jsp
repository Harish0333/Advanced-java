<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
String msg = (String)request.getParameter("msg");
out.println(msg);
%>
<%@include file="login.html" %>

</body>
</html>