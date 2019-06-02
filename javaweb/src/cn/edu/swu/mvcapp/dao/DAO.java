package cn.edu.swu.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.swu.mvcapp.db.JdbcUtils;

/*
 * 封装了基本CRUD的方法，已供子类继承方法
 * 当前DAO 直接在方法中获取数据库连接
 *  整个DAO采取DUBtils解决方法
 * */
public class DAO<T> {
	private Class<T> clazz;
	private QueryRunner queryRunner=new QueryRunner();
	@SuppressWarnings("unchecked")
	public DAO() {
		/*java反射获得泛型参数
		 * 
		 * 
			public class Person<T> {
			 
			}
			 
			import java.lang.reflect.ParameterizedType;
			import java.lang.reflect.Type;
			 
			public class Student extends Person<Student> {
			public static void main(String[] args) {
			Student st=new Student();
			Class clazz=st.getClass();
			//getSuperclass()获得该类的父类
			System.out.println(clazz.getSuperclass());
			//getGenericSuperclass()获得带有泛型的父类
			//Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
			Type type=clazz.getGenericSuperclass();
			System.out.println(type);
			//ParameterizedType参数化类型，即泛型
			ParameterizedType p=(ParameterizedType)type;
			//getActualTypeArguments获取参数化类型的数组，泛型可能有多个
			Class c=(Class) p.getActualTypeArguments()[0];
			System.out.println(c);
			}
			}
			 
			打印结果：
			 
			class com.test.Person
			com.test.Person<com.test.Student>
			class com.test.Student
		 * */
		/*
		 * https://blog.csdn.net/liang5630/article/details/40185591
		 * getSuperclass()：获得该类的父类
		 * getGenericSuperclass():获得带有泛型的父类
		 * */
		Type superClass=getClass().getGenericSuperclass();
		//ParameterizedType参数化类型，即泛型
		if(superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType=(ParameterizedType)superClass;
			//获得参数化类型的数组，泛型可能有多个
			Type [] typeArgs=parameterizedType.getActualTypeArguments();
			if(typeArgs !=null && typeArgs.length>0) {
				clazz=(Class<T>) typeArgs[0];
			}
		}
	}
	
	/*
	 * 返回某一个字段的值：
	 * 	例如返回某一条记录的customerName，
	 * 		或返回数据表中有多少条记录等
	 * */
	@SuppressWarnings("unchecked")
	public <E> E getForValue(String sql,Object ...args ) {
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return (E) queryRunner.query(connection,sql,new ScalarHandler<Object>(),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	
	//返回T所对应的List
	public List<T> getForList(String sql,Object ...args ){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection, sql,new BeanListHandler<>(clazz),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;	
	}
	
	/*
	 * 返回对应的T的一个实体类的对象
	 * */
	public T get(String sql,Object ...args) {
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection,sql, new BeanHandler<>(clazz),args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/*
	 * 该方法封装了insert、delete和update等操作
	 * args：填充sql语句的占位符
	 * */
	public void update(String sql,Object ... args) {
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			queryRunner.update(connection,sql,args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
	}
}
