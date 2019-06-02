package cn.edu.swu.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import cn.edu.swu.mvcapp.dao.LogPersonDAO;
import cn.edu.swu.mvcapp.dao.impl.LogPersonDAOJdbcImpl;
import cn.edu.swu.mvcapp.dao.impl.LogPersonDAOXMLImpl;

public class LogPersonDAOFactory {
	private Map<String,LogPersonDAO> daos=new HashMap<String,LogPersonDAO>();
	private LogPersonDAOFactory() {
		daos.put("jdbc",new LogPersonDAOJdbcImpl());
		daos.put("xml",new LogPersonDAOXMLImpl());
	}
	private static LogPersonDAOFactory instance=new LogPersonDAOFactory();
	public static LogPersonDAOFactory getInstance() {
		return instance;
	}
	private  String type=null;
	public void setType(String type) {
		this.type=type;
	}
	public LogPersonDAO getLogPersonDAO() {
		return daos.get(type);
	}
}
