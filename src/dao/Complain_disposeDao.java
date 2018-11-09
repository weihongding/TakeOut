package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Complain_dispose;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class Complain_disposeDao {

	public static void main(String[] args) {

		// 已测试功能：获取总数，增加、获取实例集合、删除、更新
		Complain_disposeDao dao = new Complain_disposeDao();
		Complain_dispose comp = dao.get(3).get(0);
		comp.setContent("将处理");
		dao.update(comp);

	}

	/**
	 * 获取投诉建议反馈总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from Complain_dispose";

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
	 * 新增投诉建议反馈
	 * 
	 * @param comp
	 */
	public void add(Complain_dispose comp) {

		String sql = "insert into Complain_dispose values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, comp.getCoid());
			ps.setInt(2, comp.getMid());
			ps.setString(3, comp.getContent());
			ps.setTimestamp(4, DateUtil.toTimestamp(new Date()));// 根据现在的时间

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
	 * 更新投诉建议反馈信息
	 * 
	 * @param comp
	 */
	public void update(Complain_dispose comp) {

		String sql = "update Complain_dispose set content = ?, Coid = ?, mid = ?, time=? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, comp.getContent());
			ps.setInt(2, comp.getCoid());
			ps.setInt(3, comp.getMid());
			ps.setTimestamp(4, DateUtil.toTimestamp(comp.getTime()));
			ps.setInt(5, comp.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除投诉建议反馈信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from Complain_dispose where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * a 根据投诉建议id得到投诉建议反馈实例集合
	 * 
	 * @param
	 * @return
	 */
	public List<Complain_dispose> get(int Coid) {
		List<Complain_dispose> compArray = new ArrayList<Complain_dispose>();

		String sql = "select * from Complain_dispose where Coid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, Coid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int mid = rs.getInt("mid");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));

				Complain_dispose comp = new Complain_dispose(Coid, mid, content, time);
				comp.setId(id);

				compArray.add(comp);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return compArray;
	}

}
