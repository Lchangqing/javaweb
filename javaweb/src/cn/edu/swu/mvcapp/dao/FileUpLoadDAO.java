package cn.edu.swu.mvcapp.dao;

import java.util.List;

import cn.edu.swu.fileupload.app.beans.FileUploadBean;

public interface FileUpLoadDAO {
	public List<FileUploadBean> getFiles();
	public void save(List<FileUploadBean> uploadFiles);
}
