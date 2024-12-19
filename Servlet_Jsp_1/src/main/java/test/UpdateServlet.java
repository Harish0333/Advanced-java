package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/updat")
@SuppressWarnings("serial")
public class UpdateServlet extends GenericServlet 
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		CustomerBean cb=new CustomerBean();
		cb.setPhNo(Long.parseLong(req.getParameter("uphno")));
		   cb.setName(req.getParameter("upname"));
		   cb.setCity(req.getParameter("upcity"));
		   cb.setmId(req.getParameter("upmid"));
		   String n1=req.getParameter("name1");
		   UpdateDAO udao=new UpdateDAO();
		   int k= udao.update(cb,n1);
		 if(k>0)
		 {
			 req.setAttribute("msg", "Updated Customer data Added Successfully...<br>");
			   RequestDispatcher rd = req.getRequestDispatcher("updatedata.jsp");
			   rd.forward(req, res);
		 }
	}
}
