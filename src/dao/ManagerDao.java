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

		// 已测试功能：获取实例、验证账号密码
		ManagerDao dao = new ManagerDao();
		System.out.println(dao.check("manager1", "manapassword"));
	}

	/**
	 * 根据id得到管理员实例
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
	 * 根据account得到管理员实例
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
	 * 验证管理员账号密码
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
					JOptionPane.showMessageDialog(null, "登录成功！", "登陆信息", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "密码错误！", "登录信息", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "账号不存在！", "登陆信息", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;

	}

}
