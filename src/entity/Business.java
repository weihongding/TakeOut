package entity;

import util.StateUtil;
import util.User;

public class Business extends User {

	private String des;
	private String phone;
	private String address;
	private String state;

	/**
	 * 商家注册/商家登陆验证
	 * 
	 * @param account
	 * @param password
	 */
	public Business(String account, String password) {
		setAccount(account);
		setPassword(password);
		setName("未命名店铺");
		setDes("暂无");
		setPhone("暂未填写");
		setState(StateUtil.busi[0]);
		setAddress("暂未填写");
	}

	/**
	 * 得到商家用户实例
	 * 
	 * @param id
	 * @param name
	 * @param des
	 * @param phone
	 * @param address
	 */
	public Business(int id, String name, String des, String phone, String address, String state) {
		setId(id);
		setName(name);
		setDes(des);
		setPhone(phone);
		setAddress(address);
		setState(state);
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
