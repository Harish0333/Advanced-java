package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/grt")
@SuppressWarnings("serial")
public class GreaterServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		int v3=((v1>v2)?v1:v2);
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Greatest :"+v3+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);

	}

}
