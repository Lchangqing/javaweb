package cn.edu.swu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet{

	  public void init() throws ServletException
	  {
	      // 执行必需的初始化
	  }

	  public void doPost(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  String username=(String)request.getParameter("user");
		  String password=(String)request.getParameter("pass");
		  System.out.println(username);
		  System.out.println(password);
		  
	      PrintWriter out = response.getWriter();
	      if(username.equals("leichangqing")&&password.equals("123456"))
	      {
	    	  out.println("<h1>Login success</h1>");
	      }else {
	    	  out.println("<h1>Login fail</h1>");
	      }
	  }
	  
	  public void destroy()
	  {
	      // 什么也不做
	  }

}
