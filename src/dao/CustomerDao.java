package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Business;
import entity.Customer;
import util.DBUtil;
import util.DateUtil;

public class CustomerDao {

	public static void main(String[] args) {

		// 已测试功能：全部
		CustomerDao dao = new CustomerDao();
		Customer cus = dao.get(7);
		System.out.println(cus.getAddress());
	}

	/**
	 * 获取顾客总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from customer";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 新增顾客
	 * 
	 * @param cus
	 */
	public void add(Customer cus) {

		String sql = "insert into customer values(null,?,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, cus.getAccount());
			ps.setString(2, cus.getPassword());
			ps.setString(3, cus.getName());
			ps.setString(4, cus.getPhone());
			ps.setString(5, cus.getAddress());
			ps.setString(6, cus.getDes());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				cus.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 更新顾客信息
	 * 
	 * @param cus
	 */
	public void update(Customer cus) {

		String sql = "update customer set name = ?, phone = ?,  address=?, des = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, cus.getName());
			ps.setString(2, cus.getPhone());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getDes());
			ps.setInt(5, cus.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除顾客信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from customer where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 根据id得到顾客实例
	 * 
	 * @param id
	 * @return
	 */
	public Customer get(int id) {
		Customer cus = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String des = rs.getString("des");

				cus = new Customer(id, name, des, phone, address);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cus;
	}

	/**
	 * 根据account得到顾客实例
	 * 
	 * @param id
	 * @return
	 */
	public Customer get(String account) {
		Customer cus = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String des = rs.getString("des");

				cus = new Customer(id, name, des, phone, address);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cus;
	}

	/**
	 * 根据phone得到顾客id
	 * 
	 * @param id
	 * @return
	 */
	public int getId(String phone) {
		int id = -1;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where phone = '" + phone + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				id = rs.getInt("id");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 验证顾客账号密码
	 * 
	 * @param account
	 * @param password
	 * @return id
	 */
	public int check(String account, String password) {
		int id = -1;

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where account = '" + account + "'";

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

	/**
	 * 检验账号是否存在
	 * 
	 * @param account
	 * @return
	 */
	public boolean check(String account) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

}
