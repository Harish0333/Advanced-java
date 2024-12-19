package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllCustomersServlet extends GenericServlet{
	@Override
   public void service(ServletRequest req,ServletResponse res)throws ServletException,
   IOException{
	   ArrayList<CustomerBean> al = new ViewAllCustomersDAO().retrieve();
	   req.setAttribute("alist", al);
	   req.getRequestDispatcher("ViewAllCustomers.jsp").forward(req, res);
   }
}

