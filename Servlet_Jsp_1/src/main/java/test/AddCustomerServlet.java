package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddCustomerServlet extends GenericServlet{
	@Override
   public void service(ServletRequest req,ServletResponse res)throws ServletException,
   IOException{
	   CustomerBean cb = new CustomerBean();//Bean-Object
	   cb.setPhNo(Long.parseLong(req.getParameter("phno")));
	   cb.setName(req.getParameter("name"));
	   cb.setCity(req.getParameter("city"));
	   cb.setmId(req.getParameter("mid"));
	   AddCustomerDAO acd = new AddCustomerDAO();
	   int k = acd.insert(cb);
	   if(k>0) {
		   req.setAttribute("msg", "Customer Added Successfully...<br>");
		   RequestDispatcher rd = req.getRequestDispatcher("AddCustomer.jsp");
		   rd.forward(req, res);
	   }
   }
}
