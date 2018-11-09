package gui.model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import util.GUIUtil;

/**
 * �˵���ģ��
 * 
 * @���� ��ΰ��
 *
 */
public class MenuTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] menus;

	static String[] columnNames1 = { "����", "�۸�" };
	static String[][] menus1 = { { "�Ǵ��Ź�", "7.0" }, { "�ع���", "7.5" } };

	static String[] columnNames2 = { "����", "�۸�", "����" };
	static String[][] menus2 = { { "�Ǵ��Ź�", "7.0"}, { "�ع���", "7.5"} };
	public static int[] num;

	public static MenuTableModel instance1 = new MenuTableModel(columnNames1, menus1);
	public static MenuTableModel instance2 = new MenuTableModel(columnNames2, menus2);

	private MenuTableModel(String[] col, String[][] men) {
		this.columnNames = col;
		this.menus = men;
		num = GUIUtil.getArray_int_num(menus2.length);
	}

	@Override
	public int getRowCount() {
		return menus.length;
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
		if(columnIndex == 2) return num[rowIndex];
		return menus[rowIndex][columnIndex];
	}

}
