package cn.edu.swu.mvcapp.dao;

import java.util.List;

import cn.edu.swu.mvcapp.domain.Customer;

public interface CustomerDAO {
	//��װ���ѯ��������������������list
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	public List<Customer> getAll();
	public void save(Customer customer);
	public Customer get(Integer id);
	public void delete(Integer id);
	public void update(Customer customre);
	//���غ�name��ȵļ�¼��
	public long getCountWithName(String name);
}
