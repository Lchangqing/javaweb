package cn.edu.swu.mvcapp.dao.impl;

import java.util.List;

import cn.edu.swu.mvcapp.dao.DAO;
import cn.edu.swu.mvcapp.dao.LogPersonDAO;
import cn.edu.swu.mvcapp.domain.LogPerson;

public class LogPersonDAOJdbcImpl extends DAO<LogPerson> implements LogPersonDAO{

	@Override
	public List<LogPerson> getAll() {
		String sql="select * from log";
		return getForList(sql);
	}


	@Override
	public LogPerson get(Integer id) {
		String sql="select * from log where id=?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql="delete from log where id=?";
		update(sql,id);
	}

	@Override
	public void update(LogPerson p) {
		String sql="update log set name=?,passwd=? where id=?";
		update(sql,p.getName(),p.getPassWd(),p.getId());
	}

	@Override
	public long getCountWithName(String name) {
		String sql="select count(id) from log where name=?";
		return getForValue(sql,name);
	}

	@Override
	public long check(String name, String passwd) {
		String sql="select count(id) from log where name=? and passwd=?";
		System.out.println("------------"+name);
		return getForValue(sql,name,passwd);
	}


	@Override
	public void save(String name, String passwd) {
		// TODO Auto-generated method stub
		String sql="insert into log(name,passwd) values(?,?)";
		update(sql,name,passwd);
	}

	




}
