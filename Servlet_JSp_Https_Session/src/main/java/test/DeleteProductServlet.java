package test;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);
        if (hs == null) 
        {
            req.setAttribute("msg", "Session Expired...<br>");
            req.getRequestDispatcher("Msg.jsp").forward(req, res);
        } 
        else 
        {
            ArrayList<ProductBean> al = (ArrayList<ProductBean>) hs.getAttribute("alist");
            String pCode = req.getParameter("pcode");
            if (al == null) 
            {
                req.setAttribute("msg", "Invalid Request...<br>");
                req.getRequestDispatcher("Msg.jsp").forward(req, res);
            } 
            else 
            {
            	 Iterator<ProductBean> it = al.iterator();
                 while (it.hasNext()) 
                 {
                     ProductBean pb = it.next();
                     if (pCode.equals(pb.getCode())) 
                     {
                         it.remove();
                         // Update database
                         int k = new DeleteProductDAO().delete(pb);
                         if (k > 0) 
                         {
                             req.setAttribute("msg", "Product Deleted Successfully...<br>");
                         } 
                         else 
                         {
                             req.setAttribute("msg", "Error: Product not deleted from database...<br>");
                         }
                         break;
                     }
                 }
                 req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
             }
         }
     }
 }