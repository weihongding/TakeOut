package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Order;
import util.DBUtil;
import util.DateUtil;
import util.NumberUtil;
import util.StateUtil;

public class OrderDao {

	public static void main(String[] args) {

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ��������
		OrderDao dao = new OrderDao();
		System.out.println(dao.earn_will(5));
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from `order`";

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
	 * ��������
	 * 
	 * @param order
	 */
	public void add(Order order) {

		String sql = "insert into `order` values(null,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, order.getBid());
			ps.setInt(2, order.getCid());
			ps.setDouble(3, order.getTotal_price());
			ps.setTimestamp(4, DateUtil.toTimestamp(new Date()));// ���ڵ�ʱ��
			ps.setString(5, StateUtil.order[0]);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				order.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * ���¶�����Ϣ
	 * 
	 * @param order
	 */
	public void update(Order order) {

		String sql = "update `order` set bid = ?, cid = ?, total_price =?, time = ? , state = ?  where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, order.getBid());
			ps.setInt(2, order.getCid());
			ps.setDouble(3, order.getTotal_price());
			ps.setTimestamp(4, DateUtil.toTimestamp(order.getTime()));// ���ڵ�ʱ��
			ps.setString(5, order.getState());
			ps.setInt(6, order.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from `order` where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * ������ݺ�id��ö����б�
	 * 
	 * @param status
	 * @param sid
	 * @return
	 */
	public List<Order> get(String status, int sid) {
		List<Order> orderArray = new ArrayList<Order>();
		String sql = "";
		if (status.equals("business"))
			sql = "select * from `order` where bid = ?";
		else if (status.equals("customer"))
			sql = "select * from `order` where cid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, sid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				double total_price = rs.getDouble("total_price");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");
				int bid = 0, cid = 0;
				if (status.equals("business")) {
					bid = sid;
					cid = rs.getInt("cid");
				} else if (status.equals("customer")) {
					bid = rs.getInt("bid");
					cid = sid;
				}

				Order order = new Order(bid, cid, total_price, time, state);
				order.setId(id);
				orderArray.add(order);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return orderArray;
	}

	/**
	 * �����̼�id������ʹﶩ��������
	 * 
	 * @param bid
	 * @return
	 */
	public double earn_have(int bid) {
		String sql = "select * from `order` where bid = ?";
		List<Double> earn = new ArrayList<>();

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("state").equals(StateUtil.order[2])) {
					earn.add(rs.getDouble("total_price"));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return NumberUtil.sum(earn);
	}

	/**
	 * �����̼�id����ѽӵ�����������
	 * 
	 * @param bid
	 * @return
	 */
	public double earn_will(int bid) {
		String sql = "select * from `order` where bid = ?";
		List<Double> earn = new ArrayList<>();

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("state").equals(StateUtil.order[1])) {
					earn.add(rs.getDouble("total_price"));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return NumberUtil.sum(earn);
	}

}
