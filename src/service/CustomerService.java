package service;

import javax.swing.JOptionPane;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService {

	static CustomerDao cdao = new CustomerDao();

	/**
	 * ע��˿�
	 * 
	 * @param account
	 * @param password
	 */
	public static void add(String account, String password) {
		Customer cus = new Customer(account, password);
		cdao.add(cus);
	}

	public static void update(Customer cus) {
		cdao.update(cus);
	}

	/**
	 * ��ù˿���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public static Customer get(int id) {
		Customer cus = new Customer(-1, "", "", "", "");
		if (id == -1)
			JOptionPane.showMessageDialog(null, "�˿���Ϣδͬ����", "", JOptionPane.ERROR_MESSAGE);
		else
			cus = cdao.get(id);
		return cus;
	}

	/**
	 * ��֤�˿��˺�����
	 * 
	 * @param account
	 * @param password
	 * @return �˿�id�������򷵻�-1
	 */
	public static int check(String account, String password) {
		return cdao.check(account, password);
	}

	/**
	 * �����˺��Ƿ��Ѵ���
	 * 
	 * @param account
	 * @return
	 */
	public static boolean check(String account) {
		return cdao.check(account);
	}

	public static int getid(String phone) {
		return cdao.getId(phone);
	}

}
