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

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ��������
		Complain_disposeDao dao = new Complain_disposeDao();
		Complain_dispose comp = dao.get(3).get(0);
		comp.setContent("������");
		dao.update(comp);

	}

	/**
	 * ��ȡͶ�߽��鷴������
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
	 * ����Ͷ�߽��鷴��
	 * 
	 * @param comp
	 */
	public void add(Complain_dispose comp) {

		String sql = "insert into Complain_dispose values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, comp.getCoid());
			ps.setInt(2, comp.getMid());
			ps.setString(3, comp.getContent());
			ps.setTimestamp(4, DateUtil.toTimestamp(new Date()));// �������ڵ�ʱ��

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
	 * ����Ͷ�߽��鷴����Ϣ
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
	 * ɾ��Ͷ�߽��鷴����Ϣ
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
	 * a ����Ͷ�߽���id�õ�Ͷ�߽��鷴��ʵ������
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
