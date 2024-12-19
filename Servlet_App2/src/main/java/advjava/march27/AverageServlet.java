package advjava.march27;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/avg")
@SuppressWarnings("serial")
public class AverageServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException, IOException 
	{
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		int v3=(v1+v2)/2;
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Average :"+v3+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);
	}

}
