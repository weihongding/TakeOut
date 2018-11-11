package gui.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gui.FrameAdd.OrderBusi;
import util.GUIUtil;

/**
 * 临时生成的购物车表
 * 
 * @作者 丁伟宏
 *
 */
public class OrderCarTableModel extends AbstractTableModel {

	String[] columnNames;
	String[][] menus;

	public static OrderCarTableModel instance;

	public OrderCarTableModel() {
		this.columnNames = OrderBusi.instance.m.columnNames;
		this.menus = GUIUtil.getArray_String(OrderBusi.instance.m, OrderBusi.instance.m.num);
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return menus.length;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return menus[rowIndex][columnIndex];
	}

}
