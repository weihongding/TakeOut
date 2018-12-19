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

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ��������
		ComplainDao dao = new ComplainDao();
		Complain comp = dao.get(9);
		System.out.println(comp.getContent());
		
	}

	/**
	 * ��ȡͶ�߽�������
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
	 * ����Ͷ�߽���
	 * 
	 * @param comp
	 */
	public void add(Complain comp) {

		String sql = "insert into complain values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, comp.getContent());
			ps.setInt(2, comp.getCid());
			ps.setTimestamp(3, DateUtil.toTimestamp(new Date()));// ���ڵ�ʱ��
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
	 * ����Ͷ�߽�����Ϣ
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
	 * ɾ��Ͷ�߽�����Ϣ
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
	 * ���ݹ˿�id�õ�Ͷ�߽���ʵ������
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
	 * ����id�õ�complainʵ��
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
