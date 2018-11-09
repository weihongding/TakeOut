package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Apply;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class ApplyDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		ApplyDao dao = new ApplyDao();
		Apply app = dao.get(5).get(0);
		app.setContent("喜欢");
		dao.add(app);
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
	 * 根据商家id得到申请实例集合
	 * 
	 * @param bid
	 * @return
	 */
	public List<Apply> get(int bid) {
		List<Apply> appArray = new ArrayList<Apply>();

		String sql = "select * from apply where bid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
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

}
