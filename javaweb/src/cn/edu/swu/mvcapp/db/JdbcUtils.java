package cn.edu.swu.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * jdbc�����Ĺ�����
 * */
public class JdbcUtils {
	private static DataSource dataSource=null;
	static {
		//����Դֻ�ܱ�����һ��
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
	//��������Դ��һ��connection����
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//��ȡ����
	
}
