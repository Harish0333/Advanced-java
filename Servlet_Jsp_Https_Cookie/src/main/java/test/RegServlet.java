package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	@Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
 IOException{
	 UserBean ub = new UserBean();//Bean Object
	 ub.setuName(req.getParameter("uname"));
	 ub.setpWord(req.getParameter("pword"));
	 ub.setfName(req.getParameter("fname"));
	 ub.setlName(req.getParameter("lname"));
	 ub.setAddr(req.getParameter("addr"));
	 ub.setmId(req.getParameter("mid"));
	 ub.setPhNo(Long.parseLong(req.getParameter("phno")));
	 int k = new RegisterDAO().register(ub);
	 if(k>0) {
		 req.setAttribute("msg","User Registered Successfully...<br>");
		 req.getRequestDispatcher("Register.jsp").forward(req, res);
	 }
 }
}

