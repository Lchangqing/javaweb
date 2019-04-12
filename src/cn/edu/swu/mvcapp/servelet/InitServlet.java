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
		//��ȡ��·����switch.properties�ļ�
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties=new Properties();
		try {
			System.out.println("initrservlet 29");
			properties.load(in);
			//��ȡswitch.properties��type ����
			System.out.println("initrservlet 31");
			String type=properties.getProperty("type");
			System.out.println("initrservlet 33");
			//������customerdaofactory��type����ֵ
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
