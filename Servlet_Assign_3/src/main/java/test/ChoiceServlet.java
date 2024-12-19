package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/choice")
@SuppressWarnings("serial")
public class ChoiceServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String s1=req.getParameter("s1");
		if(s1.equals("Sub"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("sub");
			rd.forward(req, res);				
		}
		else if(s1.equals("Mul"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mul");
			rd.forward(req, res);
		}	
		else if(s1.equals("Div"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("div");
			rd.forward(req, res);
		}	
		else if(s1.equals("Mod"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mod");
			rd.forward(req, res);
		}	
		else if(s1.equals("Grt"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("grt");
			rd.forward(req, res);
		}	
		else if(s1.equals("Lsr"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("lsr");
			rd.forward(req, res);
		}	
	}

}