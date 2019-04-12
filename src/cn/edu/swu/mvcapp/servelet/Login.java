package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.mvcapp.dao.LogPersonDAO;
import cn.edu.swu.mvcapp.dao.factory.LogPersonDAOFactory;
import cn.edu.swu.mvcapp.domain.Customer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private LogPersonDAO logpersondao=new LogPersonDAOJdbcImpl();
	private LogPersonDAO logpersondao=LogPersonDAOFactory.getInstance().getLogPersonDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //1.获取servletpath:/edit.do或add.do
		 String servletpath=request.getServletPath();
		 
		 //2.去除/和.do，得到类似于edit或add这样的字符串
		 String methodname=servletpath.substring(1,servletpath.length()-3);
		 try {
			 //3.利用放射获取methodName对应大方法
			 System.out.println("----------34");
			Method method=getClass().getDeclaredMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);
			//4.利用反射调用对应的方法
			System.out.println("----------36");
			method.invoke(this, request,response);
			System.out.println("----------39");
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("----------42");
			 response.sendRedirect("404.jsp");
			e.printStackTrace();
		} 
		 
	}

private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String name=request.getParameter("name");
	String passwd=request.getParameter("passwd");
	if(logpersondao==null) {System.out.println("空的");}
	long lenth=logpersondao.check(name, passwd);
	if(lenth==1) {
		System.out.println("----------51");
		response.sendRedirect("operate.jsp");
	}else {System.out.println("----------53");
		request.setAttribute("message", "check for errors in username or password~");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	}

private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String name=request.getParameter("name");
	String passwd=request.getParameter("passwd");
	if(passwd!=null && !passwd.equals("")&&!passwd.equals("null")&&name!=null && !name.equals("")&&!name.equals("null")) {
		System.out.println("------69 进if");
				long count=logpersondao.getCountWithName(name);
				if(count>0) {
					request.setAttribute("message", "the user's"+name+"already occupaied，please try another one~~");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}
			logpersondao.save(name, passwd);
			request.setAttribute("message", "user "+name+" created successfully~~");
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	else {
		System.out.println("------82 进else");
		request.setAttribute("message", "the username and password cannot be empty");
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
}
}
