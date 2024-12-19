package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/mod")
@SuppressWarnings("serial")
public class ModDivisionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		float v1=Float.parseFloat(req.getParameter("v1"));
		float v2=Float.parseFloat(req.getParameter("v2"));
		float v3=v1%v2;
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println(" ModDivision :"+v3+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);
	}
}
