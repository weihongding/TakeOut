package service;

import java.util.List;

import dao.FoodDao;
import dao.OtofDao;
import entity.Food;

public class FoodService {

	static FoodDao fdao = new FoodDao();
	static OtofDao otofdao = new OtofDao();
	
	/** 根据商家id获得商家的菜单 */
	public static List<Food> list_b(int bid){
		return fdao.get(bid);
	}
	
	
}
