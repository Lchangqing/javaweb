package cn.edu.swu.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * jdbc操作的工具类
 * */
public class JdbcUtils {
	private static DataSource dataSource=null;
	static {
		//数据源只能被创建一次
		dataSource=new ComboPooledDataSource("mvcapp");
	}
	public static void releaseConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//返回数据源的一个connection对象
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//获取连接
	
}
