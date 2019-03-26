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

public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	PreparedStatement ps=null; 
	ResultSet rs=null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8") ;
		String username = (String) request.getParameter("user");
		String password = (String) request.getParameter("pass");
		System.out.println(username);
		System.out.println(password);

		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			System.out.println("进conn");
			String sql="INSERT INTO userinfo(name,passwd,time) VALUES(?,?,NOW())";//?符号是占位符
			ps=con.prepareStatement(sql);
			System.out.println("43");
			ps.setObject(1,username);
			ps.setObject(2,password);
			if(ps.executeUpdate()==1) {
				System.out.println("46");
				request.getRequestDispatcher("/registsuccess.jsp").forward(request, response);
			}else {System.out.println("48");
				request.getRequestDispatcher("/registfailed.jsp").forward(request, response);
			}
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
	
	
	
	


