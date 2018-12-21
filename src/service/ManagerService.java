package service;

import dao.ManagerDao;

public class ManagerService {

	static ManagerDao mdao = new ManagerDao();

	public static int check(String account,String password){
		return mdao.check(account, password);
	}
	
}
