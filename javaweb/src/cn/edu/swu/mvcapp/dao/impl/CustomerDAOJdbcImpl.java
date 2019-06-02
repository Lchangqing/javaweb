package cn.edu.swu.mvcapp.dao.impl;

import java.util.List;

import cn.edu.swu.mvcapp.dao.CriteriaCustomer;
import cn.edu.swu.mvcapp.dao.CustomerDAO;
import cn.edu.swu.mvcapp.dao.DAO;
import cn.edu.swu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		String sql="insert into customers(name,address,phone) values(?,?,?)";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from customers where id=?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete from customers where id=?";
		update(sql,id);
		
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		System.out.println("------------"+name);
		String sql="select count(id) from customers where name=?";
		return getForValue(sql,name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		String sql="select * from customers where name like ? and address like ? and phone like ?";
		//修改了critteriacustomer的getter方法，使其返回的字符串中有"%%",
		//		若返回值位null，则返回"%%",若不为null，则返回"%"+字段本身的值+"%"
		return getForList(sql,cc.getName(),cc.getAddress(),cc.getPhone());
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		String sql="update customers set name=?,address=?,phone=? where id=?";
		 System.out.println("customerdao 61");
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
		 System.out.println("customerdao 63");
	}
	
}
