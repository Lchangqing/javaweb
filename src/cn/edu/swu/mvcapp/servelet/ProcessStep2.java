package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swu.mvcapp.domain.Customer2;

/**
 * Servlet implementation class ProcessStep2
 */
@WebServlet("/processstep2")
public class ProcessStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessStep2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求参数，name,address,cardType,card
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String cardType=request.getParameter("cardtype");
		String card=request.getParameter("card");
		//2.把请求信息存入到HttpSession中
		HttpSession session=request.getSession();
		Customer2 customer=new Customer2(name, address, cardType, card);
		session.setAttribute("customer", customer);
		//3.重定向页面到confirm.jsp
		response.sendRedirect(request.getContextPath()+"/shoppingcart/confirm.jsp");
	}

}
