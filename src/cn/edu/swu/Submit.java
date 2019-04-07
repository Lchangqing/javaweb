package cn.edu.swu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8") ;
		 request.setCharacterEncoding("UTF-8") ;
		Jdbc jdbc=new Jdbc();
		String id=(String)request.getParameter("id");
		String name=(String)request.getParameter("name");
		System.out.print(name);
		String age=(String)request.getParameter("age");
		if(id!=null && !id.equals("")&&!id.equals("null")&&name!=null && !name.equals("")&&!name.equals("null")&&age!=null && !age.equals("")&&!age.equals("null"))
		{
			List<Student> students=jdbc.submit(Integer.parseInt(id), name,Integer.parseInt(age));
			request.setAttribute("students",students);
			request.getRequestDispatcher("liststudent").forward(request, response);
		}else {
			request.getRequestDispatcher("liststudent").forward(request, response);
		}
	}
}

