package service;

import dao.OrderDao;

public class OrderService {

	static OrderDao odao = new OrderDao();

	/** 已送达订单总收入 */
	public static double earn_have(int bid) {
		return odao.earn_have(bid);
	}

	/** 已接单订单总收入 */
	public static double earn_will(int bid) {
		return odao.earn_will(bid);
	}

}
