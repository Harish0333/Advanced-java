package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	@Override
  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
  IOException{
	  String uName = req.getParameter("uname");
	  String pWord = req.getParameter("pword");
	  UserBean ub = new LoginDAO().login(uName, pWord);
	  if(ub==null) {
		  req.setAttribute("msg","Invalid Login process...<br>");
		  req.getRequestDispatcher("Msg.jsp").forward(req, res);
	  }else {
		  ServletContext sct = req.getServletContext();
		         //Accessing ServletContext Object reference
		  sct.setAttribute("ubean", ub);//Adding Bean Object to Context
		  Cookie ck = new Cookie("fname",ub.getfName());//Cookie Object
		  res.addCookie(ck);//Adding Cookie to response
		             //serialization process
		  req.getRequestDispatcher("Login.jsp").forward(req, res);
	  }
  }

}
