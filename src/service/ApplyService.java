package service;

import dao.ApplyDao;
import entity.Apply;
import util.CheckUtil;

import java.util.List;

import javax.swing.JOptionPane;

public class ApplyService {

	static ApplyDao adao = new ApplyDao();

	public static void add(Apply app) {
		int bid = app.getBid();
		if (CheckUtil.existence_String("business", "id", Integer.toString(bid)) == 0) {
			JOptionPane.showMessageDialog(null, "�̼Ҳ����ڣ�", "", JOptionPane.ERROR_MESSAGE);
		} else {
			adao.add(app);
			JOptionPane.showMessageDialog(null, "�ύ�ɹ���", "ע����Ϣ", JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * ��ȡͶ�߽��鼯��
	 */
	public static List<Apply> list() {
		return adao.list();
	}

}