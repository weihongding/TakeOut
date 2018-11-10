package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Business;
import entity.Business;
import util.DBUtil;
import util.DateUtil;

public class BusinessDao {

	public static void main(String[] args) {

		//已测试功能：获取总数、获取实例、获取实例集合、更新、新增、验证账号密码
		BusinessDao dao = new BusinessDao();
		System.out.println(dao.check("zhangzhang", "mimi"));
	}

	/**
	 * 获取商家总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from business";

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
	 * 新增商家
	 * 
	 * @param bus
	 */
	public void add(Business bus) {

		String sql = "insert into business values(null,?,?,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, bus.getAccount());
			ps.setString(2, bus.getPassword());
			ps.setString(3, bus.getName());
			ps.setString(4, bus.getPhone());
			ps.setString(5, bus.getAddress());
			ps.setString(6, bus.getState());
			ps.setString(7, bus.getDes());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				bus.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 更新商家信息
	 * 
	 * @param bus
	 */
	public void update(Business bus) {

		String sql = "update business set name = ?, phone = ?,  address=?, state = ? ,des = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, bus.getName());
			ps.setString(2, bus.getPhone());
			ps.setString(3, bus.getAddress());
			ps.setString(4, bus.getState());
			ps.setString(5, bus.getDes());
			ps.setInt(6, bus.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除商家信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from business where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 根据id得到商家实例
	 * 
	 * @param id
	 * @return
	 */
	public Business get(int id) {
		Business bus = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from business where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String des = rs.getString("des");
				String state = rs.getString("state");

				bus = new Business(id, name, des, phone, address, state);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bus;
	}
	
	/**
	 * 根据name得到商家实例
	 * 
	 * @param id
	 * @return
	 */
	public Business get(String name) {
		Business bus = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from business where name = '" + name +"'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String state = rs.getString("state");
				String des = rs.getString("des");

				bus = new Business(id, name, des, phone, address, state);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bus;
	}
	
	/**
	 * 上架中的商家列表
	 * 
	 * @return
	 */
	public List<Business> list_up() {
		List<Business> busArray = new ArrayList<Business>();

		String sql = "select * from business where state = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, "上架中");
			;

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String des = rs.getString("des");
				String state = rs.getString("state");

				Business bus = new Business(id, name, des, phone, address, state);
				busArray.add(bus);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return busArray;
	}

	/**
	 * 下架中的商家列表
	 * 
	 * @return
	 */
	public List<Business> list_down() {
		List<Business> busArray = new ArrayList<Business>();

		String sql = "select * from business where state = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, "下架中");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String des = rs.getString("des");
				String state = rs.getString("state");

				Business bus = new Business(id, name, des, phone, address, state);
				busArray.add(bus);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return busArray;
	}

	
	/**
	 * 验证商家账号密码
	 * @param account
	 * @param password
	 * @return 商家id，错误则返回-1
	 */
	public int check (String account,String password){
		int id = -1;
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from business where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String pas = rs.getString("password");
				if(pas.equals(password)){
					id = rs.getInt("id");
					JOptionPane.showMessageDialog(null, "登录成功！", "登陆信息",JOptionPane.PLAIN_MESSAGE); 
				}else{
					JOptionPane.showMessageDialog(null, "密码错误！", "登录信息",JOptionPane.ERROR_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "账号不存在！", "登陆信息",JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return id;

	}
	
	
}
