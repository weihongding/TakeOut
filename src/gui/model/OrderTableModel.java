package gui.model;

import javax.swing.table.AbstractTableModel;

/**
 * 订单表模型
 * 
 * @作者 丁伟宏
 *
 */
public class OrderTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] ordlis;

	static String[] columnNames1 = { "商家", "时间", "状态" };
	static String[][] ordlis1 = { { "商家1", "2018-10-21", "已送达" }, { "商家2", "2018-10-22", "已送达" } };

	static String[] columnNames2 = { "顾客", "时间", "状态" };
	static String[][] ordlis2 = { { "顾客1", "2018-10-21", "已送达" }, { "顾客2", "2018-10-22", "已送达" } };

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
