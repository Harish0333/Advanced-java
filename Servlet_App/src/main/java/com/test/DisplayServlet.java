package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet{
	@Override
    public void service(ServletRequest req,ServletResponse res)throws
    ServletException,IOException{
    	String userName = req.getParameter("uname");
    	String mailId = req.getParameter("mid");
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
        pw.println("*****UserDetails****<br>");
        pw.println("UserName:"+userName+"<br>");
        pw.println("MailId:"+mailId+"<br>");
    }
}

