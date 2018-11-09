package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Apply_dispose;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class Apply_disposeDao {

	public static void main(String[] args) {

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ��������
		Apply_disposeDao dao = new Apply_disposeDao();
		Apply_dispose app = dao.get(18).get(0);
		app.setContent("����ɹ���");
		dao.update(app);

	}

	/**
	 * ��ȡ���뷴������
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from apply_dispose";

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
	 * �������뷴��
	 * 
	 * @param app
	 */
	public void add(Apply_dispose app) {

		String sql = "insert into apply_dispose values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, app.getAid());
			ps.setInt(2, app.getMid());
			ps.setString(3, app.getContent());
			ps.setTimestamp(4, DateUtil.toTimestamp(new Date()));// ���ڵ�ʱ��

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
	 * �������뷴����Ϣ
	 * 
	 * @param app
	 */
	public void update(Apply_dispose app) {

		String sql = "update apply_dispose set content = ?, aid = ?, mid = ?, time=? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, app.getContent());
			ps.setInt(2, app.getAid());
			ps.setInt(3, app.getMid());
			ps.setTimestamp(4, DateUtil.toTimestamp(app.getTime()));
			ps.setInt(5, app.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * ɾ�����뷴����Ϣ
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from apply_dispose where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * a ��������id�õ����뷴��ʵ������
	 * 
	 * @param
	 * @return
	 */
	public List<Apply_dispose> get(int aid) {
		List<Apply_dispose> appArray = new ArrayList<Apply_dispose>();

		String sql = "select * from apply_dispose where aid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, aid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int mid = rs.getInt("mid");
				String content = rs.getString("content");
				Date time = DateUtil.toDate(rs.getTimestamp("time"));

				Apply_dispose app = new Apply_dispose(aid, mid, content, time);
				app.setId(id);

				appArray.add(app);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return appArray;
	}

}
