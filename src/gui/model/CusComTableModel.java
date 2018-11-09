package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * 投诉建议表模型
 * 
 * @see 目前数据StringList
 * @作者 丁伟宏
 *
 */
public class CusComTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] comLis;
	
	static String[] columnNames1 = { "编号", "顾客", "时间","状态" };
	static String[][] comLis1 = {{"1","顾客1","2018-10-20","已处理"},{"2","顾客2","2018-10-21","已处理"},{"3","顾客1","2018-10-21","未处理"}};
	
	static String[] columnNames2 = {"时间","状态"};
	static String[][] comLis2 = {{"2018-10-20","已处理"},{"2018-10-21","未处理"}};

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
