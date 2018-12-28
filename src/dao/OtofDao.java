package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Otof;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class OtofDao {

	public static void main(String[] args) {

		// 已测试功能：全部
		OtofDao dao = new OtofDao();
		System.out.println(dao.getSales(8));

	}

	/**
	 * 获取订单菜品关系表总数
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from otof";

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
	 * 新增订单菜品关系表
	 * 
	 * @param otof
	 */
	public void add(Otof otof) {

		String sql = "insert into otof values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, otof.getOid());
			ps.setInt(2, otof.getFid());
			ps.setInt(3, otof.getCount());
			ps.setDouble(4, otof.getSum_price());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				otof.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 更新订单菜品关系表信息
	 * 
	 * @param otof
	 */
	public void update(Otof otof) {

		String sql = "update otof set oid = ?, fid = ?,  count = ?, sum_price = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, otof.getOid());
			ps.setInt(2, otof.getFid());
			ps.setInt(3, otof.getCount());
			ps.setDouble(4, otof.getSum_price());
			ps.setInt(5, otof.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 删除订单菜品关系表信息
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from otof where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 根据菜单id得到订单菜品关系表实例集合
	 * 
	 * @param oid
	 * @return
	 */
	public List<Otof> get(int oid) {
		List<Otof> otofArray = new ArrayList<Otof>();

		String sql = "select * from otof where oid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, oid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int fid = rs.getInt("fid");
				int count = rs.getInt("count");
				double sum_price = rs.getDouble("sum_price");
				int id = rs.getInt("id");

				Otof otof = new Otof(oid, fid, count, sum_price);
				otof.setId(id);

				otofArray.add(otof);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return otofArray;
	}

	/**
	 * 根据菜品id统计销量
	 * @param fid
	 * @return
	 */
	public int getSales(int fid) {
		int count = 0;
		String sql = "select * from otof where fid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, fid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;
	}

}
