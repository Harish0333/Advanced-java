<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditProduct Jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="line-height:1.8;">
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Page belongs to Admin:"+ab.getfName()+"<br>");
ProductBean pb = (ProductBean)request.getAttribute("pbean");
%>
<form action="update" method="post">
<input type="hidden" name="pcode" value=<%=pb.getCode() %>>
ProductPrice:<input type="text" name="price" value=<%=pb.getPrice() %>><br>
ProductQty:<input type="text" name="qty" value=<%=pb.getQty() %>><br><br>
<input type="submit" value="UpdateProduct">
</form>

</body>
</html>