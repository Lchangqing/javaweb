package cn.edu.swu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	PreparedStatement ps=null; 
	ResultSet rs=null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8") ;
<<<<<<< bdbf626bc0eafa51bdcfcf79839b24cdde4f9e00
		String username = (String) request.getParameter("user");
		String password = (String) request.getParameter("pass");
		System.out.println(username);
=======
		 request.setCharacterEncoding("UTF-8") ;
		String username = (String) request.getParameter("user");
		String password = (String) request.getParameter("pass");
		System.out.println(username);
		System.out.println(password);
>>>>>>> point of mvc

		PrintWriter out = response.getWriter();
		
		try {
<<<<<<< bdbf626bc0eafa51bdcfcf79839b24cdde4f9e00
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			 System.out.println("连接成功");
			String sql="select * from userinfo where name=? and passwd=?";
			ps=con.prepareStatement(sql);
			ps.setObject(1,username);
			ps.setObject(2,password);
			rs=ps.executeQuery();
			 System.out.println("准备进入if");
=======
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			System.out.println("进conn");
			String sql="select * from userinfo where name=? and passwd=?";//?符号是占位符
			System.out.println("41");
			ps=con.prepareStatement(sql);
			System.out.println("43");
			ps.setObject(1,username);
			ps.setObject(2,password);
			rs=ps.executeQuery();
			System.out.println("47");
>>>>>>> point of mvc
			while(true) {
				System.out.println("49");
			if(rs.next()) {
  				   System.out.println("51");
//					System.out.println(rs.getInt(1)+"----------"+rs.getString(2)+"-----------"+rs.getString(3));
<<<<<<< bdbf626bc0eafa51bdcfcf79839b24cdde4f9e00
					System.out.println("进if");
					request.getRequestDispatcher("/second.jsp").forward(request, response);
=======
//					out.println("login success!!");
					System.out.println("进if");
					request.getRequestDispatcher("liststudent").forward(request, response);
>>>>>>> point of mvc
					break;
				}else {
					System.out.println("进else");
					request.getRequestDispatcher("/failed.jsp").forward(request, response);
			}}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	}
	
	
	
	


