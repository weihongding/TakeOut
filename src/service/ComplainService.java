package service;

import java.util.Date;
import java.util.List;

import dao.ComplainDao;
import dao.Complain_disposeDao;
import entity.Complain;
import entity.Complain_dispose;
import util.StateUtil;

public class ComplainService {

	static ComplainDao cdao = new ComplainDao();
	static Complain_disposeDao cddao = new Complain_disposeDao();

	public static void add(Complain comp) {
		cdao.add(comp);
	}

	public static void add(Complain_dispose compdis) {
		Complain comp = cdao.get(compdis.getCoid());
		comp.setState(StateUtil.complain[1]);
		cdao.update(comp);
		cddao.add(compdis);
	}

	public static Complain get(int coid) {
		return cdao.get(coid);
	}

	public static Complain get(int cid, Date time) {
		return cdao.get(cid, time);
	}

	public static List<Complain_dispose> list_dis(int coid) {
		return cddao.list(coid);
	}

	/**
	 * 根据顾客id返回投诉建议
	 * 
	 * @param cid
	 * @return
	 */
	public static List<Complain> list(int cid) {
		return cdao.list(cid);
	}

	/**
	 * @return 所有投诉建议
	 */
	public static List<Complain> list() {
		return cdao.list();
	}

	/**
	 * 根据coid获得最后一条回复
	 * 
	 * @param coid
	 * @return
	 */
	public static Complain_dispose get_dis_last(int coid) {
		if (cdao.get(coid).getState().equals(StateUtil.complain[0]))
			return null;
		return cddao.list(coid).get(cddao.list(coid).size() - 1);
	}

}
