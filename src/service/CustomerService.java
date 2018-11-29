package service;

import javax.swing.JOptionPane;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService {

	static CustomerDao cdao = new CustomerDao();

	/**
	 * 注册顾客
	 * 
	 * @param account
	 * @param password
	 */
	public static void add(String account, String password) {
		Customer cus = new Customer(account, password);
		cdao.add(cus);
	}

	public static void update(Customer cus){
		cdao.update(cus);
	}
	
	/**
	 * 获得顾客信息
	 * 
	 * @param id
	 * @return
	 */
	public static Customer get(int id) {
		Customer cus = new Customer(-1, "", "", "", "");
		if (id == -1)
			JOptionPane.showMessageDialog(null, "顾客信息未同步！", "", JOptionPane.ERROR_MESSAGE);
		else
			cus = cdao.get(id);
		return cus;
	}

	/**
	 * 验证顾客账号密码
	 * 
	 * @param account
	 * @param password
	 * @return 顾客id，错误则返回-1
	 */
	public static int check(String account, String password) {

		return cdao.check(account, password);

	}

}
