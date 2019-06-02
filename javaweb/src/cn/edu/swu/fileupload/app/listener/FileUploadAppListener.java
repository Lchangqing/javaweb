package cn.edu.swu.fileupload.app.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.edu.swu.fileupload.app.utils.FileUploadAppProperties;

/**
 * Application Lifecycle Listener implementation class FileUploadAppListener
 *
 */
public class FileUploadAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FileUploadAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	InputStream in = getClass().getClassLoader().getResourceAsStream("/upload.properties");
    	
    	Properties properties = new Properties();
    	/*
    	 * Map的entrySet函数的使用，取得是键和值的映射关系，Entry就是Map接口中的内部接口，类似与我们熟悉的内部类一样，内部类定义在外部类内部，可以直接访问到外部类中的成员
    	 *
		 * private static void method_3(Map<Integer, String> map) {
			   Set entrySet=map.entrySet();//entrySet()方法返回反应map键值的映射关系，存储在set集合中
			   Iterator it=entrySet.iterator();//使用迭代器获得每一个映射关系
			   while(it.hasNext()){
			    Map.Entry me=(Map.Entry) it.next();//映射关系类型为Map.Entry类型，是一个接口类型
			    System.out.println(me.getKey()+":::"+me.getValue());
			 //   System.out.println(me.getValue());
		   }
    	 * 
    	 * 
    	 * */
    	try {
			properties.load(in);
			
			for(Map.Entry<Object, Object> prop: properties.entrySet()){
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				
				FileUploadAppProperties.getInstance().addProperty(propertyName, propertyValue);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
