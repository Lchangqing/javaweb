package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessStepServlet
 */
@WebServlet("/ProcessStepServlet")
public class ProcessStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取选中的图书信息
		String[] books=request.getParameterValues("book");
		//2.把图书信息放入到HTTPsession中
		request.getSession().setAttribute("books", books);
		//3.重定向页面到shoppingcart/step-2.jsp
		System.out.println(request.getContextPath()+"/shoppingcart/step-2.jsp");
		response.sendRedirect(request.getContextPath()+"/shoppingcart/step-2.jsp");
	}

}
