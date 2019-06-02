package cn.edu.swu.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import cn.edu.swu.mvcapp.dao.FileUpLoadDAO;
import cn.edu.swu.mvcapp.dao.impl.FileUpLoadDAOJdbcImpl;
import cn.edu.swu.mvcapp.dao.impl.FileUpLoadDAOXMLImpl;

public class FileUpLoadDAOFactory {
	private Map<String,FileUpLoadDAO> daos=new HashMap<String,FileUpLoadDAO>();
	private FileUpLoadDAOFactory() {
		daos.put("jdbc",new FileUpLoadDAOJdbcImpl());
		daos.put("xml",new FileUpLoadDAOXMLImpl());
	}
	private static FileUpLoadDAOFactory instance=new FileUpLoadDAOFactory();
	public static FileUpLoadDAOFactory getInstance() {
		return instance;
	}
	private  String type=null;
	public void setType(String type) {
		this.type=type;
	}
	public FileUpLoadDAO getFileUpLoadDAO() {
		return daos.get(type);
	}
}
