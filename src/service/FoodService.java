package service;

import java.util.List;

import dao.FoodDao;
import dao.OtofDao;
import entity.Food;

public class FoodService {

	static FoodDao fdao = new FoodDao();
	static OtofDao otofdao = new OtofDao();

	/** 根据商家id获得商家的菜单 */
	public static List<Food> list_b(int bid) {
		return fdao.get(bid);
	}

	public static void add(Food food) {
		fdao.add(food);
	}

	public static void update(Food food) {
		fdao.update(food);
	}

	public static Food get(int bid, String foodname) {
		return fdao.get(bid, foodname);
	}

	public static Food get(int foodid) {
		return fdao.get_fid(foodid);
	}
	
	public static void delete(Food food){
		fdao.delete(food.getId());
	}

	public static int getSales(int fid){
		return otofdao.getSales(fid);
	}
	
}
