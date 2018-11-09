package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Ͷ�߽����ģ��
 * 
 * @see Ŀǰ����StringList
 * @���� ��ΰ��
 *
 */
public class CusComTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] comLis;
	
	static String[] columnNames1 = { "���", "�˿�", "ʱ��","״̬" };
	static String[][] comLis1 = {{"1","�˿�1","2018-10-20","�Ѵ���"},{"2","�˿�2","2018-10-21","�Ѵ���"},{"3","�˿�1","2018-10-21","δ����"}};
	
	static String[] columnNames2 = {"ʱ��","״̬"};
	static String[][] comLis2 = {{"2018-10-20","�Ѵ���"},{"2018-10-21","δ����"}};

	public static CusComTableModel instance_m = new CusComTableModel(columnNames1,comLis1);
	public static CusComTableModel instance_c = new CusComTableModel(columnNames2,comLis2);

	private CusComTableModel(String[] col,String[][] com) {
		this.columnNames = col;
		this.comLis = com;
	}

	@Override
	public int getRowCount() {
		return comLis.length;
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
		return comLis[rowIndex][columnIndex];
	}

}
