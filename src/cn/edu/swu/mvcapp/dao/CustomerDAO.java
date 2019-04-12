package cn.edu.swu.mvcapp.dao;

import java.util.List;

import cn.edu.swu.mvcapp.domain.Customer;

public interface CustomerDAO {
	//封装里查询条件，返回满足条件的list
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	public List<Customer> getAll();
	public void save(Customer customer);
	public Customer get(Integer id);
	public void delete(Integer id);
	public void update(Customer customre);
	//返回和name相等的记录数
	public long getCountWithName(String name);
}
