package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Apply;
import entity.Customer;
import entity.Order;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class ApplyDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		ApplyDao dao = new ApplyDao();
		Apply app = dao.get(18);
		System.out.println(app.getContent());
	}

	/**
	 * 获取申请总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from apply";

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
	 * 新增申请
	 * 
	 * @param app
	 */
	public void add(Apply app) {

		String sql = "insert into apply values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, app.getContent());
			ps.setInt(2, app.getBid());
			ps.setTimestamp(3, DateUtil.toTimestamp(new Date()));// 现在的时间
			ps.setString(4, StateUtil.apply[0]);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				app.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 更新申请信息
	 * 
	 * @param app
	 */
	public void update(Apply app) {

		String sql = "update apply set content = ?, bid = ?,  time=?, state = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, app.getContent());
			ps.setInt(2, app.getBid());
			ps.setTimestamp(3, DateUtil.toTimestamp(app.getTime()));
			ps.setString(4, app.getState());
			ps.setInt(5, app.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除申请信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from Apply where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 得到申请实例集合
	 * 
	 * @param bid
	 * @return
	 */
	public List<Apply> list() {
		List<Apply> appArray = new ArrayList<Apply>();

		String sql = "select * from apply";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int bid = rs.getInt("bid");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");

				Apply app = new Apply(bid, content, time, state);
				app.setId(id);

				appArray.add(app);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return appArray;
	}

	/**
	 * 根据id得到申请实例
	 * 
	 * @param id
	 * @return
	 */
	public Apply get(int id) {
		Apply app = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from apply where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int bid = rs.getInt("bid");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");

				app = new Apply(bid, content, time, state);
				app.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return app;
	}

	/**
	 * 根据商家id以及时间返回apply实例
	 * 
	 * @param bid
	 * @param cid
	 * @param time
	 * @return
	 */
	public Apply get(int bid, Date time) {
		java.sql.Timestamp t_time = DateUtil.toTimestamp(time);
		Apply app = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from apply where bid = '" + bid + "' AND time = '" + t_time + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				String state = rs.getString("state");
				
				app = new Apply(bid, content, t_time, state);
				app.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return app;
	}

}
