package service;

import java.util.List;

import javax.swing.JOptionPane;

import dao.BusinessDao;
import entity.Business;

public class BusinessService {

	static BusinessDao bdao = new BusinessDao();

	/**
	 * ע���̼�
	 * 
	 * @param account
	 * @param password
	 */
	public static void add(String account, String password) {
		Business bus = new Business(account, password);
		bdao.add(bus);
	}

	/**
	 * ����̼���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public static Business get(int id) {

		Business bus = new Business(-1, "", "", "", "", "");
		if (id == -1)
			JOptionPane.showMessageDialog(null, "�̼���Ϣδͬ����", "", JOptionPane.ERROR_MESSAGE);
		else
			bus = bdao.get(id);
		return bus;

	}

	/**
	 * �����̼�������̼�id
	 * 
	 * @param name
	 * @return
	 */
	public static int getid(String name) {
		return bdao.get(name).getId();
	}

	/**
	 * �����̼���Ϣ
	 * 
	 * @param bus
	 */
	public static void update(Business bus) {
		bdao.update(bus);
	}

	/**
	 * ��֤�̼��˺�����
	 * 
	 * @param account
	 * @param password
	 * @return �̼�id�������򷵻�-1
	 */
	public static int check(String account, String password) {

		return bdao.check(account, password);

	}

	/**
	 * ��ȡ�ϼ��е��̼��б�
	 */
	public static List<Business> list_up() {
		return bdao.list_up();
	}

	/**
	 * ��ȡ�¼��е��̼��б�
	 */
	public static List<Business> list_down() {
		return bdao.list_down();
	}

}
