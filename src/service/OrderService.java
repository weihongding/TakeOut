package service;

import java.util.Date;
import java.util.List;

import dao.FoodDao;
import dao.OrderDao;
import dao.OtofDao;
import entity.Order;
import entity.Otof;
import util.GUIUtil;

public class OrderService {

	static OrderDao odao = new OrderDao();
	static FoodDao fdao = new FoodDao();
	static OtofDao otofdao = new OtofDao();

	/** ���ʹﶩ�������� */
	public static double earn_have(int bid) {
		return odao.earn_have(bid);
	}

	/** �ѽӵ����������� */
	public static double earn_will(int bid) {
		return odao.earn_will(bid);
	}

	/**
	 * ���ݹ��ﳵ���涩�������ݿ�
	 * 
	 * @param bid
	 * @param cid
	 * @param str
	 * @return
	 */
	public static boolean add(int bid, int cid, String[][] str) {
		double total_price = 0;

		String foodname;
		double price, sum_price;
		int count;
		int fid;
		Order order = new Order(bid, cid);
		odao.add(order);
		order = odao.get_last();
		int oid = order.getId();
		if (oid != -1) {
			for (int i = 0; i < str.length; i++) {
				foodname = str[i][0];
				price = Double.parseDouble(str[i][1]);
				count = Integer.parseInt(str[i][2]);
				sum_price = price * count;
				fid = fdao.get(bid, foodname).getId();
				Otof otf = new Otof(oid, fid, count, sum_price);
				otofdao.add(otf);
				total_price += sum_price;
			}
			order.setId(oid);
			order.setTotal_price(total_price);
			odao.update(order);
			return true;
		} else {
			return false;
		}
	}

	public static Order get(int bid, int cid, Date time) {
		return odao.get(bid, cid, time);
	}

	public static List<Order> get(String status, int sid) {
		return odao.get(status, sid);
	}

	public static List<Otof> getotof(int oid) {
		return otofdao.get(oid);
	}

	public static void update(Order order){
		odao.update(order);
	}
	
}
