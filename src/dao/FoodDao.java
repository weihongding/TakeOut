package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import entity.Customer;
import entity.Food;
import util.DBUtil;
import util.DateUtil;
import util.StateUtil;

public class FoodDao {

	public static void main(String[] args) {

		// �Ѳ��Թ��ܣ���ȡ���������ӡ���ȡʵ�����ϡ�ɾ������ȡ����ʵ��
		FoodDao dao = new FoodDao();
		Food food = dao.get(5, "�ع���");
		food.setPrice(1);
		dao.update(food);
	}

	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @return int
	 */
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from food";

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
	 * ������Ʒ
	 * 
	 * @param food
	 */
	public void add(Food food) {

		String sql = "insert into food values(null,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, food.getName());
			ps.setDouble(2, food.getPrice());
			ps.setString(3, food.getImage());
			ps.setInt(4, food.getBid());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				food.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * ���²�Ʒ��Ϣ
	 * 
	 * @param food
	 */
	public void update(Food food) {

		String sql = "update food set name = ?, price = ?, image =?, bid = ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, food.getName());
			ps.setDouble(2, food.getPrice());
			ps.setString(3, food.getImage());
			ps.setInt(4, food.getBid());
			ps.setInt(5, food.getId());
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * ɾ����Ʒ��Ϣ
	 * 
	 * @param id
	 */
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from food where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * �����̼�id�õ���Ʒʵ������
	 * 
	 * @param bid
	 * @return
	 */
	public List<Food> get(int bid) {
		List<Food> foodArray = new ArrayList<Food>();

		String sql = "select * from food where bid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String image = rs.getString("image");

				Food food = new Food(name, price, image, bid);
				food.setId(id);

				foodArray.add(food);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return foodArray;
	}

	public Food get(int bid, String foodname) {

		Food food = null;

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from food where bid = '" + bid + "' AND name = '" + foodname + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String image = rs.getString("image");

				food = new Food(name, price, image, bid);
				food.setId(id);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return food;

	}

}
