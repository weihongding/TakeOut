package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Complain;
import service.ComplainService;
import service.CustomerService;
import util.DateUtil;
import util.GUIUtil;

/**
 * Ͷ�߽����ģ��
 * 
 * @see Ŀǰ����StringList
 * @���� ��ΰ��
 *
 */
public class CusComTableModel extends AbstractTableModel {

	String[] columnNames;
	List<Complain> comLis;

	static String[] columnNames1 = { "���", "�˿�id", "ʱ��", "״̬" };
	static String[] columnNames2 = { "ʱ��", "״̬" };

	public static CusComTableModel instance_m = new CusComTableModel(columnNames1, ComplainService.list());
	public static CusComTableModel instance_c = new CusComTableModel(columnNames2,
			ComplainService.list(GUIUtil.cus_id));

	private CusComTableModel(String[] col, List<Complain> com) {
		this.columnNames = col;
		this.comLis = com;
	}

	public void setComlis(List<Complain> com) {
		this.comLis = com;
	}

	@Override
	public int getRowCount() {
		return comLis.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnNames[columnIndex].equals("���"))
			return comLis.get(rowIndex).getId();
		if (columnNames[columnIndex].equals("�˿�id"))
			return CustomerService.get(comLis.get(rowIndex).getCid()).getId();
		if (columnNames[columnIndex].equals("ʱ��"))
			return DateUtil.formatDate(comLis.get(rowIndex).getTime());
		if (columnNames[columnIndex].equals("״̬"))
			return comLis.get(rowIndex).getState();
		return null;
	}

}
