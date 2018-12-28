package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Manager;
import util.DBUtil;
import util.DateUtil;

public class ManagerDao {

	public static void main(String[] args) {

		// �Ѳ��Թ��ܣ�ȫ��
		ManagerDao dao = new ManagerDao();
		System.out.println(dao.check("manager1", "manapassword"));
	}

	/**
	 * ����id�õ�����Աʵ��
	 * 
	 * @param id
	 * @return
	 */
	public Manager get(int id) {
		Manager mana = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from Manager where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				mana = new Manager(id, name);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return mana;
	}

	/**
	 * ����account�õ�����Աʵ��
	 * 
	 * @param id
	 * @return
	 */
	public Manager get(String account) {
		Manager mana = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from Manager where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				mana = new Manager(id, name);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return mana;
	}

	/**
	 * ��֤����Ա�˺�����
	 * 
	 * @param account
	 * @param password
	 * @return id
	 */
	public int check(String account, String password) {
		int id = -1;

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from Manager where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String pas = rs.getString("password");
				if (pas.equals(password)) {
					id = rs.getInt("id");
					JOptionPane.showMessageDialog(null, "��¼�ɹ���", "��½��Ϣ", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�������", "��¼��Ϣ", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "�˺Ų����ڣ�", "��½��Ϣ", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;

	}

}
