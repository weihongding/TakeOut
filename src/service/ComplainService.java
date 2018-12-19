package service;

import java.util.List;

import dao.ComplainDao;
import dao.Complain_disposeDao;
import entity.Complain;
import entity.Complain_dispose;

public class ComplainService {

	static ComplainDao cdao = new ComplainDao();
	static Complain_disposeDao cddao = new Complain_disposeDao();
	
	public static void add(Complain comp){
		cdao.add(comp);
	}
	
	public static Complain get(int coid){
		return cdao.get(coid);
	}
	
	public static List<Complain_dispose> get_dis(int coid){
		return cddao.list(coid);
	}
	
	public static Complain_dispose get_dis_last(int coid){
		return cddao.list(coid).get(cddao.list(coid).size()-1);
	}
	
}
