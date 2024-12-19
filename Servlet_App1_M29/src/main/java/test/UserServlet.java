package test;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/user")
@SuppressWarnings("serial")
public class UserServlet extends GenericServlet 
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String s1=req.getParameter("UD");
		if(s1.equals("Submit"))
		{
			String uid=req.getParameter("uname");
			String ufn=req.getParameter("fname");
			String uln=req.getParameter("lname");
			String mid=req.getParameter("mail");
			long ph=Long.parseLong(req.getParameter("phno"));
		
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			
			pw.print("User ID :"+uid+"<br>");
			pw.print("User FName :"+ufn+"<br>");
			pw.print("User LName :"+uln+"<br>");
			pw.print("User MailId :"+mid+"<br>");
			pw.print("User PhNo :"+ph+"<br>");
	
		}	
	}
}
