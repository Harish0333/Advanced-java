package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
 IOException{
	 HttpSession hs = req.getSession(false);
	 if(hs==null) 
	 {
		 req.setAttribute("msg", "Session Expired...<br>");
		 req.getRequestDispatcher("Msg.jsp").forward(req, res);
	 }
	 else 
	 {
		 ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
		 String pCode=req.getParameter("pcode");
		 float pPrice = Float.parseFloat(req.getParameter("price"));
		 int pQty = Integer.parseInt(req.getParameter("qty"));
		 Iterator<ProductBean> it = al.iterator();
		 while(it.hasNext()) {
			 ProductBean pb = (ProductBean)it.next();
			 if(pCode.equals(pb.getCode())) {
				 pb.setPrice(pPrice);//Updating ProductBean
				 pb.setQty(pQty);//Updating ProductBean
				 int k = new UpdateProductDAO().update(pb);
				 if(k>0){
					req.setAttribute("msg", "Product Updated Successfully...<br>");
					req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
				 }//end of if
				 break;
			 }//end of if
		 }//end of while
	 }
 }
}

