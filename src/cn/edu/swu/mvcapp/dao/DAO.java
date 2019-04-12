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
 * ��װ�˻���CRUD�ķ������ѹ�����̳з���
 * ��ǰDAO ֱ���ڷ����л�ȡ���ݿ�����
 *  ����DAO��ȡDUBtils�������
 * */
public class DAO<T> {
	private Class<T> clazz;
	private QueryRunner queryRunner=new QueryRunner();
	@SuppressWarnings("unchecked")
	public DAO() {
		/*java�����÷��Ͳ���
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
			//getSuperclass()��ø���ĸ���
			System.out.println(clazz.getSuperclass());
			//getGenericSuperclass()��ô��з��͵ĸ���
			//Type�� Java ����������������͵Ĺ����߼��ӿڡ����ǰ���ԭʼ���͡����������͡��������͡����ͱ����ͻ������͡�
			Type type=clazz.getGenericSuperclass();
			System.out.println(type);
			//ParameterizedType���������ͣ�������
			ParameterizedType p=(ParameterizedType)type;
			//getActualTypeArguments��ȡ���������͵����飬���Ϳ����ж��
			Class c=(Class) p.getActualTypeArguments()[0];
			System.out.println(c);
			}
			}
			 
			��ӡ�����
			 
			class com.test.Person
			com.test.Person<com.test.Student>
			class com.test.Student
		 * */
		/*
		 * https://blog.csdn.net/liang5630/article/details/40185591
		 * getSuperclass()����ø���ĸ���
		 * getGenericSuperclass():��ô��з��͵ĸ���
		 * */
		Type superClass=getClass().getGenericSuperclass();
		//ParameterizedType���������ͣ�������
		if(superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType=(ParameterizedType)superClass;
			//��ò��������͵����飬���Ϳ����ж��
			Type [] typeArgs=parameterizedType.getActualTypeArguments();
			if(typeArgs !=null && typeArgs.length>0) {
				clazz=(Class<T>) typeArgs[0];
			}
		}
	}
	
	/*
	 * ����ĳһ���ֶε�ֵ��
	 * 	���緵��ĳһ����¼��customerName��
	 * 		�򷵻����ݱ����ж�������¼��
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
	
	
	//����T����Ӧ��List
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
	 * ���ض�Ӧ��T��һ��ʵ����Ķ���
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
	 * �÷�����װ��insert��delete��update�Ȳ���
	 * args�����sql����ռλ��
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
