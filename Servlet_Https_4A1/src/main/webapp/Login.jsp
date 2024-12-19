<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
<link rel="stylesheet" type="text/css" href="loginstyle.css">
</head>
<body>
<%
UserBean ub = (UserBean)application.getAttribute("ubean");
out.println("Welcome User : "+ub.getEmpname()+"<br>");
%>

</body>
</html>