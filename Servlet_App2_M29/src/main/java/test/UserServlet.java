package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/first")
@SuppressWarnings("serial")
public class UserServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String s1=req.getParameter("c1");
		if(s1.equals("Click"))
		{
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String mid=req.getParameter("mid");
			long mob=Long.parseLong(req.getParameter("mob"));
			String add=req.getParameter("add");
			
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			pw.print(""+fname+"<br>");
			pw.print(""+lname+"<br>");
			pw.print(""+mid+"<br>");
			pw.print(""+mob+"<br>");
			pw.print(""+add+"<br>");
		}
	}
}
