package gui.model;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import entity.Apply;
import entity.Food;
import service.BusinessService;
import service.FoodService;
import util.DateUtil;
import util.GUIUtil;

/**
 * 菜单表模型
 * 
 * @作者 丁伟宏
 *
 */
public class MenuTableModel extends AbstractTableModel {

	String[] columnNames;
	List<Food> menus;

	static String[] columnNames1 = { "菜名", "价格" };

	public static int[] num;

	public static MenuTableModel instance1 = new MenuTableModel(columnNames1, FoodService.list_b(GUIUtil.bus_id));

	private MenuTableModel(String[] col, List<Food> menus) {
		this.columnNames = col;
		this.menus = menus;
	}

	public MenuTableModel(int bid) {
		String[] columnNames2 = { "菜名", "价格", "数量" };
		this.columnNames = columnNames2;
		this.menus = FoodService.list_b(bid);
		num = GUIUtil.getArray_int_num(menus.size());
	}

	@Override
	public int getRowCount() {
		return menus.size();
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
		if (columnNames[columnIndex].equals("菜名"))
			return menus.get(rowIndex).getName();
		if (columnNames[columnIndex].equals("价格"))
			return menus.get(rowIndex).getPrice();
		if (columnNames[columnIndex].equals("数量"))
			return num[rowIndex];
		return null;
	}

}
