package cn.edu.swu.mvcapp.dao.impl;

import java.util.List;

import cn.edu.swu.fileupload.app.beans.FileUploadBean;
import cn.edu.swu.mvcapp.dao.DAO;
import cn.edu.swu.mvcapp.dao.FileUpLoadDAO;

public class FileUpLoadDAOJdbcImpl extends DAO<FileUploadBean> implements FileUpLoadDAO {

	@Override
	public List<FileUploadBean> getFiles() {
		String sql = "SELECT id, file_name fileName, file_path filePath, " +
				"file_desc fileDesc FROM upload_files";
		return getForList(sql);
	}

	@Override
	public void save(List<FileUploadBean> uploadFiles) {
		String sql = "INSERT INTO upload_files (file_name, file_path, file_desc) VALUES " +
				"(?, ?, ?)";
		for(FileUploadBean file: uploadFiles){
			update(sql, file.getFileName(), file.getFilePath(), file.getFileDesc());
		}
	}

}
