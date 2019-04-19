package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.formIssue.TokenProcessor;

public class TokenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8") ;
		 request.setCharacterEncoding("UTF-8") ;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		HttpSession session = request.getSession();
//		Object token = session.getAttribute("token");
//		String tokenValue = request.getParameter("token");
//		System.out.println(token); 
//		System.out.println(tokenValue); 
//
//		if(token != null && token.equals(tokenValue)){
//			session.removeAttribute("token");
//		}else{
//			response.sendRedirect(request.getContextPath() + "/token/token.jsp");
//			return;
//		}
		
		boolean valid = TokenProcessor.getInstance().isTokenValid(request);
		System.out.println(valid);
		if(valid){
			System.out.println("token-----------39");
			TokenProcessor.getInstance().resetToken(request);
		}else{
			request.getSession().setAttribute("msg2", null);
			request.getSession().setAttribute("msg", "don't click any more,it's already been submitted~~");
			response.sendRedirect(request.getContextPath() + "/formSubmit.jsp");
			return;
		}
		request.getSession().setAttribute("msg", null);
		String content=request.getParameter("content");
		request.getSession().setAttribute("msg2", content);
		//访问数据库服务器...
		//request.getRequestDispatcher("/token/success.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/formSubmit.jsp");
	}

}

