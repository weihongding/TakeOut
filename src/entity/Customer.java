package entity;

import util.User;

public class Customer extends User {

	private String des;
	private String phone;
	private String address;

	/**
	 * 顾客注册/验证顾客登陆
	 * 
	 * @param account
	 * @param password
	 */
	public Customer(String account, String password) {
		setAccount(account);
		setPassword(password);
		setName("未命名顾客");
		setDes("暂无");
		setPhone("暂未填写");
		setAddress("暂未填写");
	}

	/**
	 * 得到顾客类实例
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
