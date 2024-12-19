<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile Jsp</title>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body style="font-family:cursive;">
<%
UserBean ub = (UserBean)application.getAttribute("ubean");
String fName = (String)request.getAttribute("fname");
out.println("Page belongs to : "+fName+"<br>");
%>
<form action="update" method="post" style="padding:0px 100px 130px 80px;">
<h3 style="width:200px;height:35px;">Enter new Details</h3>
Address:<input type="text" name="addr" value=<%=ub.getAddr() %>><br>
MailId:<input type="text" name="mid" value=<%=ub.getmId() %>><br>
PhoneNo:<input type="text" name="phno" value=<%=ub.getPhNo() %>><br><br>
<input type="submit" value="Update Profile">
</form>

</body>
</html>