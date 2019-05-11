package cn.edu.swu.mvcapp.servelet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.swu.fileupload.app.beans.FileUploadBean;
import cn.edu.swu.fileupload.app.exception.InvalidExtNameException;
import cn.edu.swu.fileupload.app.utils.FileUploadAppProperties;
import cn.edu.swu.fileupload.app.utils.FileUtils;
import cn.edu.swu.mvcapp.dao.impl.FileUpLoadDAOJdbcImpl;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String FILE_PATH = "/ruanjian/files/";
	
	private static final String TEMP_DIR = "/ruanjian/tempDirectory/";
	
	private FileUpLoadDAOJdbcImpl dao = new FileUpLoadDAOJdbcImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String path = null;
		
		ServletFileUpload upload = getServletFileUpload();
		
		try {
			System.out.println("==========fileupload  50");
			
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();
			System.out.println("==========fileupload  53");
			List<FileItem> items = upload.parseRequest(request);
			System.out.println("==========fileupload  55");
			List<FileUploadBean> beans = buildFileUploadBeans(items, uploadFiles);
			System.out.println("==========fileupload  57");
			vaidateExtName(beans);

			System.out.println("==========fileupload  60");
			upload(uploadFiles);
			System.out.println("==========fileupload  62");
			saveBeans(beans);
			System.out.println("==========fileupload  64");
			FileUtils.delAllFile(TEMP_DIR);
			System.out.println("==========fileupload  66");
			path = "/app/success.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/app/upload.jsp";
			request.setAttribute("message", e.getMessage());
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	//https://www.cnblogs.com/liuyangv/p/8298997.html
	/*
	 * 使用Apache文件上传组件处理文件上传步骤：
	 * 
	 */
	private ServletFileUpload getServletFileUpload() {
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
	  
		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File(TEMP_DIR);
		factory.setRepository(tempDirectory);
		//2、核心操作类:创建一个文件上传解析器。
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		
		return upload;
	}

	
	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) throws UnsupportedEncodingException {
		List<FileUploadBean> beans = new ArrayList<>();
		
		Map<String, String> descs = new HashMap<>();
		
		for(int i = 0; i < items.size(); i++){
			//如果fileitem中封装的是普通输入项的数据（输出名、值）
			FileItem item = items.get(i);
			
			if(item.isFormField()){
				//普通输入项数据的名
				String fieldName = item.getFieldName();
				//解决普通输入项的数据的中文乱码问题
				//普通输入项的值
				String desc = item.getString("UTF-8");
				
				descs.put(fieldName, desc);
			}
		}
		
		for(int i = 0; i < items.size(); i++){
			FileItem item = items.get(i);
			FileUploadBean bean = null;
			 //如果fileitem中封装的是上传文件，得到上传的文件名称， 
			if(!item.isFormField()){
				//普通输入项数据的名
				String fieldName = item.getFieldName();
				String descName = "desc" + fieldName.substring(fieldName.length() - 1);
				String desc = descs.get(descName); 
				//上传文件的名
				String fileName = item.getName();
				String filePath = getFilePath(fileName);
				
				bean = new FileUploadBean(fileName, filePath, desc);
				beans.add(bean);
				
				uploadFiles.put(bean.getFilePath(), item);
			}			
		}
		
		return beans;
	}
	private String getFilePath(String fileName) {
		String extName = fileName.substring(fileName.lastIndexOf("."));
		Random random = new Random();
		
		String filePath = FILE_PATH  + System.currentTimeMillis() + random.nextInt(100000) + extName;
		return filePath;
	}
	private void saveBeans(List<FileUploadBean> beans) {
		dao.save(beans); 
	}

	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		for(Map.Entry<String, FileItem> uploadFile: uploadFiles.entrySet()){
			String filePath = uploadFile.getKey();
			FileItem item = uploadFile.getValue();
			System.out.println("uploadFile.getValue()"+uploadFile.getValue());
			System.out.println("item.getInputStream():"+item.getInputStream());
			upload(filePath, item.getInputStream());
		}
	}


	private void upload(String filePath, InputStream inputStream) throws IOException {
		OutputStream out = new FileOutputStream(filePath);
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = inputStream.read(buffer)) != -1){
			System.out.println("len:"+len);
			out.write(buffer, 0, len);
		}
		
		inputStream.close();
		out.close();
		
		System.out.println(filePath); 
	}


	private void vaidateExtName(List<FileUploadBean> beans) {
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		System.out.println(extList);
		
		for(FileUploadBean bean: beans){
			String fileName = bean.getFileName();
			System.out.println(fileName.indexOf(".")); 
			
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println(extName); 
			
			if(!extList.contains(extName)){
				throw new InvalidExtNameException(fileName + "文件的扩展名不合法");
			}
		}
	}



	


}
