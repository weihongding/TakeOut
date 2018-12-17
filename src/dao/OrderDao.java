package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Food;
import entity.Order;
import util.DBUtil;
import util.DateUtil;
import util.GUIUtil;
import util.NumberUtil;
import util.StateUtil;

public class OrderDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		OrderDao dao = new OrderDao();
		Order order = new Order(5, 7);
		dao.add(order);
	}

	/**
	 * 获取订单总数
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
	 * 新增订单
	 * 
	 * @param order
	 */
	public void add(Order order) {

		String sql = "insert into `order` values(null,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, order.getBid());
			ps.setInt(2, order.getCid());
			ps.setDouble(3, order.getTotal_price());
			ps.setTimestamp(4, DateUtil.toTimestamp(new Date()));// 现在的时间
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
	 * 更新订单信息
	 * 
	 * @param order
	 */
	public void update(Order order) {

		String sql = "update `order` set bid = ?, cid = ?, total_price =?, time = ? , state = ?  where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, order.getBid());
			ps.setInt(2, order.getCid());
			ps.setDouble(3, order.getTotal_price());
			ps.setTimestamp(4, DateUtil.toTimestamp(order.getTime()));// 现在的时间
			ps.setString(5, order.getState());
			ps.setInt(6, order.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除订单信息
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
	 * 根据身份和id获得订单列表
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
	 * 根据商家id获得已送达订单总收入
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
	 * 根据商家id获得已接单订单总收入
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

	/**
	 * 获取最后一行的订单
	 * 
	 * @return
	 */
	public Order get_last() {

		Order order = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from `order` order by id DESC limit 1";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				int cid = rs.getInt("cid");
				int bid = rs.getInt("bid");
				double total_price = rs.getDouble("total_price");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");

				order = new Order(bid, cid, total_price, time, state);
				order.setId(id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return order;

	}

	/**
	 * 根据商家id、顾客id以及时间返回order实例
	 * 
	 * @param bid
	 * @param cid
	 * @param time
	 * @return
	 */
	public Order get(int bid, int cid, Date time) {
		java.sql.Timestamp t_time = DateUtil.toTimestamp(time);
		Order order = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from `order` where bid = '" + bid + "' AND cid = '" + cid + "' AND time = '" + t_time
					+ "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				double total_price = rs.getDouble("total_price");
				String state = rs.getString("state");

				order = new Order(bid, cid, total_price, t_time, state);
				order.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return order;
	}

}
