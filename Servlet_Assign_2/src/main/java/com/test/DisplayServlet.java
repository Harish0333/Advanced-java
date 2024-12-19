package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
@SuppressWarnings("serial")
public class DisplayServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String code=req.getParameter("code");
		String name=req.getParameter("namee");
		String auth=req.getParameter("auth");
		String price=req.getParameter("price");
		String qty=req.getParameter("qty");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("***********Book_Details********");
		pw.println("Code :"+code+"<br>");
		pw.println("Namee :"+name+"<br>");
		pw.println("Author :"+auth+"<br>");
		pw.println("Price :"+price+"<br>");
		pw.println("Quantity :"+qty+"<br>");
		
	}

}
