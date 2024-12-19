package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Clogin")
@SuppressWarnings("serial")
public class CustomerLoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	  IOException{
		  String uName = req.getParameter("uname");
		  String pWord = req.getParameter("pword");
		 CustomerBean cb = new CustomerLoginDAO().login(uName, pWord);
		  if(cb==null) {
			  req.setAttribute("msg","Invalid Login process...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  }else {
			  HttpSession hs = req.getSession();//Creating new Session
			  hs.setAttribute("cbean", cb);
			  req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		  }
	  }
}
