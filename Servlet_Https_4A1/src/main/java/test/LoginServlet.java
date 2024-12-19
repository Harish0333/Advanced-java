package test;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/log")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		 String eName = req.getParameter("ename");
		 int eid = Integer.parseInt(req.getParameter("eid"));
		  UserBean ub = new LoginDAO().login(eName, eid);
		  if(ub==null) 
		  {
			  req.setAttribute("msg","Invalid Login process...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  }
		  else {
			  ServletContext sct = req.getServletContext();
			         //Accessing ServletContext Object reference
			  sct.setAttribute("ubean", ub);//Adding Bean Object to Context
			  Cookie ck = new Cookie("ename",ub.getEmpname());//Cookie Object
			  res.addCookie(ck);//Adding Cookie to response
			             //serialization process
			  req.getRequestDispatcher("Login.jsp").forward(req, res);
		  }
	}
}
