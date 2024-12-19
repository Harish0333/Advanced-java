package advjava.march27;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/choice")
@SuppressWarnings("serial")
public class ChoiceServlet extends GenericServlet 
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException, IOException 
	{
			String s1=req.getParameter("s1");
			if(s1.equals("Add"))
			{
				RequestDispatcher rd=req.getRequestDispatcher("add");
				rd.forward(req, res);				
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("avg");
				rd.forward(req, res);
			}		
	}
}
