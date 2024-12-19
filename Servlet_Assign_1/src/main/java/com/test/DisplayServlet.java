package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
@SuppressWarnings("serial")

public class DisplayServlet extends GenericServlet 
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws
	ServletException, IOException 
	{
		String code=req.getParameter("code");
		String Name=req.getParameter("cname");
		String price=req.getParameter("price");
		String Qty=req.getParameter("qty");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("*****Product_Details****<br>");
		pw.println("Code :"+code+"<br>");
		pw.println("Name :"+Name+"<br>");
		pw.println("Price :"+price+"<br>");
		pw.println("Quantity :"+Qty+"<br>");
	}

}
