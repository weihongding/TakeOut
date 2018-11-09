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

		//�Ѳ��Թ��ܣ���ȡ��������ȡʵ������ȡʵ�����ϡ����¡���������֤�˺�����
		BusinessDao dao = new BusinessDao();
		System.out.println(dao.check("zhangzhang", "mimi"));
	}

	/**
	 * ��ȡ�̼�����
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
	 * �����̼�
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
	 * �����̼���Ϣ
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
	 * ɾ���̼���Ϣ
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
	 * ����id�õ��̼�ʵ��
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
	 * ����name�õ��̼�ʵ��
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
	 * �ϼ��е��̼��б�
	 * 
	 * @return
	 */
	public List<Business> list_up() {
		List<Business> busArray = new ArrayList<Business>();

		String sql = "select * from business where state = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, "�ϼ���");
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
	 * �¼��е��̼��б�
	 * 
	 * @return
	 */
	public List<Business> list_down() {
		List<Business> busArray = new ArrayList<Business>();

		String sql = "select * from business where state = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, "�¼���");

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
	 * ��֤�̼��˺�����
	 * @param account
	 * @param password
	 * @return id
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
					JOptionPane.showMessageDialog(null, "��¼�ɹ���", "��½��Ϣ",JOptionPane.PLAIN_MESSAGE); 
				}else{
					JOptionPane.showMessageDialog(null, "�������", "��¼��Ϣ",JOptionPane.ERROR_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "�˺Ų����ڣ�", "��½��Ϣ",JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return id;

	}
	
	
}
