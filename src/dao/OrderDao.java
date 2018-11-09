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
import util.StateUtil;

public class OrderDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		OrderDao dao = new OrderDao();
		Order order = dao.get("business", 5).get(0);
		order.setState(StateUtil.order[2]);
		dao.update(order);
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
				int bid=0,cid=0;
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

}
