<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAll Products</title>
<link rel="stylesheet" type="text/css" href="style.css">	
</head>
<body>
<div>
<%! @SuppressWarnings("unchecked") %>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("alist");
out.println("Page belongs to"+"<br>"+" Admin:"+ab.getfName()+"<br>");
%>

<h4>Code &nbsp;Name &nbsp; Price &nbsp; Quantity </h4>
<p>
<%
if(al.size()==0)
{
	out.println("Not Products available...<br>");
}
else
{
	Iterator<ProductBean> it = al.iterator();
	while(it.hasNext())
	{
		ProductBean pb = (ProductBean)it.next();
	    out.println(pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+
		     pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"&nbsp&nbsp"+"<br>"+
	    		"<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"+"&nbsp&nbsp"+
		     "<a href='delete?pcode="+pb.getCode()+"'>Delete</a><br>");
}
}
%>
<br>
<br>
<a href="logout" style="background-image: linear-gradient(to right, rgba(255,0,0,0), rgba(83, 136, 219));">Logout</a>
</p>
</div>
</body>
</html>