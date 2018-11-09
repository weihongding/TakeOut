package service;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService {

	CustomerDao cdao = new CustomerDao();
	
	public void add(String account,String password){
		Customer cus = new Customer(account, password);
		cdao.add(cus);
	}
	
}
