package cn.edu.swu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("studentid");
		Jdbc jdbc=new Jdbc();
		System.out.println("delet.java 22");
		jdbc.delet(Integer.parseInt(id));
		System.out.println("delet.java 24");
		request.getRequestDispatcher("liststudent").forward(request, response);
		System.out.println("delet.java 27");
	}
}

