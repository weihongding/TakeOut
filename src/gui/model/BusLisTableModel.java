package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.AbstractTableModel;

/**
 * 商户表模型
 * 
 * @作者 丁伟宏
 *
 */
public class BusLisTableModel extends AbstractTableModel {

	String[] columnNames;
	String[] buslis;

	// 模拟数据四组
	// 暂时用String[]替代，以后用arraylist取service的数据
	static String[] bus_up = { "上架中的店铺1", "上架中的店铺2","上架中的店铺3"};
	static String[] bus_down = { "下架中的店铺1", "下架中的店铺2", "下架中的店铺3" };
	static String[] bus_app = { "申请上架的店铺1" ,"申请上架的店铺2"};

	static String[] columnNames1 = { "店名", "简介" };
	static String[] columnNames2 = { "店名", "申请时间", "处理情况" };

	public static BusLisTableModel instance_up = new BusLisTableModel(columnNames1, bus_up);
	public static BusLisTableModel instance_down = new BusLisTableModel(columnNames1, bus_down);
	public static BusLisTableModel instance_app = new BusLisTableModel(columnNames2, bus_app);

	private BusLisTableModel(String[] column, String[] bus) {
		this.columnNames = column;
		this.buslis = bus;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return buslis.length;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnNames[columnIndex].equals("店名"))
			return buslis[rowIndex];
		if (columnNames[columnIndex].equals("简介"))
			return "暂无简介";
		if (columnNames[columnIndex].equals("申请时间"))
			return "暂无时间";
		if (columnNames[columnIndex].equals("处理情况"))
			return "暂未处理";
		return null;
	}

}
