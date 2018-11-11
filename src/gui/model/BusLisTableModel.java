package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.AbstractTableModel;

import entity.Apply;
import entity.Business;
import service.ApplyService;
import service.BusinessService;
import util.DateUtil;

/**
 * 商户表模型
 * 
 * @作者 丁伟宏
 *
 */
public class BusLisTableModel extends AbstractTableModel {

	List array = null;
	String[] columnNames = null;

	static String[] columnNames1 = { "店名", "简介" };
	static String[] columnNames2 = { "店名", "申请时间", "处理情况" };

	public static BusLisTableModel instance_up = new BusLisTableModel(columnNames1, BusinessService.list_up());
	public static BusLisTableModel instance_down = new BusLisTableModel(columnNames1, BusinessService.list_down());
	public static BusLisTableModel instance_app = new BusLisTableModel(columnNames2, ApplyService.list());

	private BusLisTableModel(String[] column, List array) {
		this.columnNames = column;
		this.array = array;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return array.size();
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (array.get(0) instanceof Apply) {
			int bid = ((Apply) array.get(rowIndex)).getBid();
			if (columnNames[columnIndex].equals("店名"))
				return BusinessService.get(bid).getName();
			if (columnNames[columnIndex].equals("申请时间"))
				return DateUtil.formatDate(((Apply) array.get(rowIndex)).getTime());
			if (columnNames[columnIndex].equals("处理情况"))
				return ((Apply) array.get(rowIndex)).getState();
		}
		if (array.get(0) instanceof Business) {
			if (columnNames[columnIndex].equals("店名"))
				return ((Business) array.get(rowIndex)).getName();
			if (columnNames[columnIndex].equals("简介"))
				return ((Business) array.get(rowIndex)).getDes();
		}

		return null;
	}

}
