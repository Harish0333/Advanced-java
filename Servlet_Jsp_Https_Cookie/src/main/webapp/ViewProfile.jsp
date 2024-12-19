<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile Jsp Page</title>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body style="
	border-style: ridge;
	border-radius: 12px;
	padding:10px;
	color:blue;
	line-height:2.0;
	width:400px;
	height:200px;
	font-family:cursive;">
<%
UserBean ub = (UserBean)application.getAttribute("ubean");
String fName = (String)request.getAttribute("fname");
out.println("Page belongs to : "+fName+"<br>");
out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+
     ub.getAddr()+"&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getPhNo()+"&nbsp&nbsp"+"<br><br>"+
		"<a href='edit'>Edit</a>");
%>
<a href="logout">Logout</a>
</body>
</html>