package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cn.edu.swu.mvcapp.dao.factory.CustomerDAOFactory;
import cn.edu.swu.mvcapp.dao.factory.LogPersonDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/initservlet")
public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		CustomerDAOFactory.getInstance().setType("jdbc");
		LogPersonDAOFactory.getInstance().setType("jdbc");
		//读取类路径下switch.properties文件
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties=new Properties();
		try {
			System.out.println("initrservlet 29");
			properties.load(in);
			//获取switch.properties的type 属性
			System.out.println("initrservlet 31");
			String type=properties.getProperty("type");
			System.out.println("initrservlet 33");
			//赋给了customerdaofactory的type属性值
			CustomerDAOFactory.getInstance().setType(type);
			LogPersonDAOFactory.getInstance().setType(type);
			System.out.println("initrservlet 34");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("initrservlet 38");
			e.printStackTrace();
		}
	}

}
