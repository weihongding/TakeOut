package service;

import dao.OrderDao;

public class OrderService {

	static OrderDao odao = new OrderDao();

	/** ���ʹﶩ�������� */
	public static double earn_have(int bid) {
		return odao.earn_have(bid);
	}

	/** �ѽӵ����������� */
	public static double earn_will(int bid) {
		return odao.earn_will(bid);
	}

}
