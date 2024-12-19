package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/CReg")
public class CustomerRegServlet extends HttpServlet {
	@Override
	 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	 IOException{
		 CustomerBean cb = new CustomerBean();//Bean Object
		 cb.setuName(req.getParameter("uname"));
		 cb.setpWord(req.getParameter("pword"));
		 cb.setfName(req.getParameter("fname"));
		 cb.setlName(req.getParameter("lname"));
		 cb.setAddr(req.getParameter("addr"));
		 cb.setmId(req.getParameter("mid"));
		 cb.setPhNo(Long.parseLong(req.getParameter("phno")));
		 int k = new CustomerRegDAO().register(cb);
		 if(k>0) {
			 req.setAttribute("msg","User Registered Successfully...<br>");
			 req.getRequestDispatcher("Register.jsp").forward(req, res);
		 }
		 else
		 {
			 req.setAttribute("msg","User failed to Register...<br>");
			 req.getRequestDispatcher("Register.jsp").forward(req, res); 
		 }
	 }
}
