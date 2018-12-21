package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Apply;
import entity.Complain;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class ComplainDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		ComplainDao dao = new ComplainDao();
		Complain comp = dao.list(7).get(dao.list(7).size() - 1);
		System.out.println(comp.getContent());

	}

	/**
	 * 获取投诉建议总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from complain";

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
	 * 新增投诉建议
	 * 
	 * @param comp
	 */
	public void add(Complain comp) {

		String sql = "insert into complain values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, comp.getContent());
			ps.setInt(2, comp.getCid());
			ps.setTimestamp(3, DateUtil.toTimestamp(new Date()));// 现在的时间
			ps.setString(4, StateUtil.complain[0]);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				comp.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 更新投诉建议信息
	 * 
	 * @param comp
	 */
	public void update(Complain comp) {

		String sql = "update Complain set content = ?, cid = ?,  time=?, state = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, comp.getContent());
			ps.setInt(2, comp.getCid());
			ps.setTimestamp(3, DateUtil.toTimestamp(comp.getTime()));
			ps.setString(4, comp.getState());
			ps.setInt(5, comp.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除投诉建议信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from Complain where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 根据顾客id得到投诉建议实例集合
	 * 
	 * @param cid
	 * @return
	 */
	public List<Complain> list(int cid) {
		List<Complain> compArray = new ArrayList<Complain>();

		String sql = "select * from Complain where cid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, cid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");

				Complain comp = new Complain(cid, content, time, state);
				comp.setId(id);

				compArray.add(comp);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return compArray;
	}

	/**
	 * 得到所有投诉建议集合
	 * 
	 * @return
	 */
	public List<Complain> list() {
		List<Complain> compArray = new ArrayList<Complain>();

		String sql = "select * from complain";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");
				int cid = rs.getInt("cid");

				Complain comp = new Complain(cid, content, time, state);
				comp.setId(id);

				compArray.add(comp);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return compArray;
	}

	/**
	 * 根据顾客id和时间得到complain实例
	 * 
	 * @param cid
	 * @param time
	 * @return
	 */
	public Complain get(int cid, Date time) {
		java.sql.Timestamp t_time = DateUtil.toTimestamp(time);
		Complain com = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from complain where cid = '" + cid + "' AND time = '" + t_time + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				String state = rs.getString("state");

				com = new Complain(cid, content, t_time, state);
				com.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return com;
	}

	/**
	 * 根据id得到complain实例
	 * 
	 * @param id
	 * @return
	 */
	public Complain get(int id) {
		Complain comp = null;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from complain where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int cid = rs.getInt("cid");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));
				String state = rs.getString("state");

				comp = new Complain(cid, content, time, state);
				comp.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return comp;
	}

}
