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

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ��������
		ApplyDao dao = new ApplyDao();
		Apply app = dao.list().get(1);
		System.out.println(app.getContent());
	}

	/**
	 * ��ȡ��������
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
	 * ��������
	 * 
	 * @param app
	 */
	public void add(Apply app) {

		String sql = "insert into apply values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, app.getContent());
			ps.setInt(2, app.getBid());
			ps.setTimestamp(3, DateUtil.toTimestamp(new Date()));// ���ڵ�ʱ��
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
	 * ����������Ϣ
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
	 * ɾ��������Ϣ
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
	 * �õ�����ʵ������
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

}
