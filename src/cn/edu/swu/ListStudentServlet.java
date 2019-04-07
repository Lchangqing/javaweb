package cn.edu.swu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/liststudent")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8") ;
		 request.setCharacterEncoding("UTF-8") ;
		Jdbc jdbc=new Jdbc();
		System.out.println("Liststudent.java 33");
		List<Student> students=jdbc.getAll();
		System.out.println("Liststudent.java 37");
//		request.setAttribute("students",Arrays.asList("aa","bb","cc") );
		request.setAttribute("students",students);
		request.getRequestDispatcher("students.jsp").forward(request, response);
		System.out.println("Liststudent.java 41");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

}
