package entity;

import util.User;

public class Customer extends User {

	private String des;
	private String phone;
	private String address;

	/**
	 * �˿�ע��/��֤�˿͵�½
	 * 
	 * @param account
	 * @param password
	 */
	public Customer(String account, String password) {
		setAccount(account);
		setPassword(password);
		setName("δ�����˿�");
		setDes("����");
		setPhone("��δ��д");
		setAddress("��δ��д");
	}

	/**
	 * �õ��˿���ʵ��
	 * 
	 * @param id
	 * @param name
	 * @param des
	 * @param phone
	 * @param address
	 */
	public Customer(int id, String name, String des, String phone, String address) {
		setId(id);
		setName(name);
		setDes(des);
		setPhone(phone);
		setAddress(address);
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
