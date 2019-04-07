package cn.edu.swu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null; 
		ResultSet rs=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("jdbc.java 22");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			System.out.println("进conn");
			String sql="select * from student";//?符号是占位符
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("jdbc.java 29");
//					System.out.println(rs.getInt(1)+"----------"+rs.getString(2)+"-----------"+rs.getString(3));
					int id=rs.getInt(2);
					System.out.println("jdbc.java 32");
					String name=rs.getString(3);
					int age=rs.getInt(4);
					Student student=new Student(id,name,age);
					students.add(student);
					System.out.println("jdbc.java 37");
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
		System.out.println("jdbc.java 71");
			return students;
			
	}
	public List<Student> delet(Integer id) {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null; 
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("jdbc.java 22");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			System.out.println("进conn");
			String sql="delete from student where studentid=?";//?符号是占位符
			ps=con.prepareStatement(sql);
			ps.setObject(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
		System.out.println("jdbc.java 71");
			return students;
			
	}
	public List<Student> submit(Integer id,String name,Integer age) {
		List<Student> students=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null; 
		ResultSet rs=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01?useSSL=false&characterEncoding=utf8","root","123456");
			System.out.println("进conn");
			String sql="INSERT INTO student(studentid,name,age) VALUES(?,?,?)";//?符号是占位符
			ps=con.prepareStatement(sql);
			System.out.println("43");
			ps.setObject(1,id);
			ps.setObject(2,name);
			ps.setObject(3,age);
			ps.executeUpdate();
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
		return students;
	}
}

