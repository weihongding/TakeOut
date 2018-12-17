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

		// 已测试功能：获取总数，增加、获取实例集合、删除、获取单个实例
		FoodDao dao = new FoodDao();
		Food food = dao.get(5, "回锅肉");
		food.setPrice(1);
		dao.update(food);
	}

	/**
	 * 获取菜品总数
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
	 * 新增菜品
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
	 * 更新菜品信息
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
	 * 删除菜品信息
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
	 * 根据商家id得到菜品实例集合
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

	/**
	 * 根据商家ID和菜品名得到菜品实例
	 * @param bid
	 * @param foodname
	 * @return
	 */
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
