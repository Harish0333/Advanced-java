<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<CustomerBean> al = (ArrayList<CustomerBean>)request.getAttribute("alist");
if(al.size()==0){
	out.println("Customers Not available...<br>");
}else{
	Iterator<CustomerBean> it = al.iterator();
	while(it.hasNext())
	{
		CustomerBean cb = (CustomerBean)it.next();
		out.println(cb.getPhNo()+"&nbsp&nbsp"+cb.getName()+"&nbsp&nbsp"+
		    cb.getCity()+"&nbsp&nbsp"+cb.getmId()+"<br>");
	}
}
%>
<%@include file="home.html"%>
</body>
</html>

