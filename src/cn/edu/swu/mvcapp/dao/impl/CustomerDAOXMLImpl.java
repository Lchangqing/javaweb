package cn.edu.swu.mvcapp.dao.impl;

import java.util.List;

import cn.edu.swu.mvcapp.dao.CriteriaCustomer;
import cn.edu.swu.mvcapp.dao.CustomerDAO;
import cn.edu.swu.mvcapp.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO{

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		System.out.print("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		System.out.print("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.print("save");
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		System.out.print(" get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		System.out.print("delete");
		
	}

	@Override
	public void update(Customer customre) {
		// TODO Auto-generated method stub
		System.out.print("update");
		
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		System.out.print(" getCountWithName");
		return 0;
	}

}
