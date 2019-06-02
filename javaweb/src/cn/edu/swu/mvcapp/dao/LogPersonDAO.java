package cn.edu.swu.mvcapp.dao;

import java.util.List;

import cn.edu.swu.mvcapp.domain.LogPerson;

public interface LogPersonDAO {
	public List<LogPerson> getAll();
	public void save(String name,String passwd);
	public LogPerson get(Integer id);
	public void delete(Integer id);
	public void update(LogPerson customre);
	public long check(String name,String passwd);
	//���غ�name��ȵļ�¼��
	public long getCountWithName(String name);
}
