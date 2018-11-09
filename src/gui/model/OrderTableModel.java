package gui.model;

import javax.swing.table.AbstractTableModel;

/**
 * ������ģ��
 * 
 * @���� ��ΰ��
 *
 */
public class OrderTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] ordlis;

	static String[] columnNames1 = { "�̼�", "ʱ��", "״̬" };
	static String[][] ordlis1 = { { "�̼�1", "2018-10-21", "���ʹ�" }, { "�̼�2", "2018-10-22", "���ʹ�" } };

	static String[] columnNames2 = { "�˿�", "ʱ��", "״̬" };
	static String[][] ordlis2 = { { "�˿�1", "2018-10-21", "���ʹ�" }, { "�˿�2", "2018-10-22", "���ʹ�" } };

	public static OrderTableModel instance_c = new OrderTableModel(columnNames1, ordlis1);
	public static OrderTableModel instance_b = new OrderTableModel(columnNames2, ordlis2);

	private OrderTableModel(String[] col, String[][] ord) {
		this.columnNames = col;
		this.ordlis = ord;
	}

	public static void main(String[] args) {
		System.out.println(ordlis1.length);
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return ordlis.length;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ordlis[rowIndex][columnIndex];
	}

}
