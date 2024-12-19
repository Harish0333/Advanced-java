package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/reg")
@SuppressWarnings("serial")
public class RegServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		UserBean ub = new UserBean();
        ub.setUname(req.getParameter("uname"));
        ub.setPword(req.getParameter("pword"));
        ub.setFname(req.getParameter("fname"));
        ub.setLname(req.getParameter("lname"));
        ub.setAdd(req.getParameter("add"));
        ub.setMid(req.getParameter("mid"));
        ub.setPhno(Long.parseLong(req.getParameter("phno")));

        RegisterDAO rdao = new RegisterDAO();
        int k = rdao.Register(ub);
        if (k > 0) 
        {
            req.setAttribute("msg", "User Registered successfully");
        }
        else 
        {
            req.setAttribute("msg", "User registration failed");
        }
        RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
        rd.forward(req, res);
	}
}
