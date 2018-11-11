package service;

import java.util.List;

import javax.swing.JOptionPane;

import dao.BusinessDao;
import entity.Business;

public class BusinessService {

	static BusinessDao bdao = new BusinessDao();

	/**
	 * 注册商家
	 * 
	 * @param account
	 * @param password
	 */
	public static void add(String account, String password) {
		Business bus = new Business(account, password);
		bdao.add(bus);
	}

	/**
	 * 获得商家信息
	 * 
	 * @param id
	 * @return
	 */
	public static Business get(int id) {

		Business bus = new Business(-1, "", "", "", "", "");
		if (id == -1)
			JOptionPane.showMessageDialog(null, "商家信息未同步！", "", JOptionPane.ERROR_MESSAGE);
		else
			bus = bdao.get(id);
		return bus;

	}

	/**
	 * 根据商家名获得商家id
	 * 
	 * @param name
	 * @return
	 */
	public static int getid(String name) {
		return bdao.get(name).getId();
	}

	/**
	 * 更新商家信息
	 * 
	 * @param bus
	 */
	public static void update(Business bus) {
		bdao.update(bus);
	}

	/**
	 * 验证商家账号密码
	 * 
	 * @param account
	 * @param password
	 * @return 商家id，错误则返回-1
	 */
	public static int check(String account, String password) {

		return bdao.check(account, password);

	}

	/**
	 * 获取上架中的商家列表
	 */
	public static List<Business> list_up() {
		return bdao.list_up();
	}

	/**
	 * 获取下架中的商家列表
	 */
	public static List<Business> list_down() {
		return bdao.list_down();
	}

}
