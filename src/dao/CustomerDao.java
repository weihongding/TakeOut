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

		//�Ѳ��Թ��ܣ���ȡ��������ȡʵ�������ӡ�ɾ�������¡���֤�˺�����
		CustomerDao dao = new CustomerDao();
		System.out.println(dao.getId("18050782349"));
	}

	/**
	 * ��ȡ�˿�����
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
	 * �����˿�
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
	 * ���¹˿���Ϣ
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
	 * ɾ���˿���Ϣ
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
	 * ����id�õ��˿�ʵ��
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
	 * ����account�õ��˿�ʵ��
	 * 
	 * @param id
	 * @return
	 */
	public Customer get(String account) {
		Customer cus = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where account = '" + account+ "'";

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
	 * ����phone�õ��˿�id
	 * 
	 * @param id
	 * @return
	 */
	public int getId(String phone) {
		int id = -1;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where phone = '" + phone+ "'";

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
	 * ��֤�˿��˺�����
	 * @param account
	 * @param password
	 * @return id
	 */
	public int check (String account,String password){
		int id = -1;
		
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from customer where account = '" + account + "'";

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
