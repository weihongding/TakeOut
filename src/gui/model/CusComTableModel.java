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
 * 投诉建议表模型
 * 
 * @see 目前数据StringList
 * @作者 丁伟宏
 *
 */
public class CusComTableModel extends AbstractTableModel {

	String[] columnNames;
	List<Complain> comLis;

	static String[] columnNames1 = { "编号", "顾客id", "时间", "状态" };
	static String[] columnNames2 = { "时间", "状态" };

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
		if (columnNames[columnIndex].equals("编号"))
			return comLis.get(rowIndex).getId();
		if (columnNames[columnIndex].equals("顾客id"))
			return CustomerService.get(comLis.get(rowIndex).getCid()).getId();
		if (columnNames[columnIndex].equals("时间"))
			return DateUtil.formatDate(comLis.get(rowIndex).getTime());
		if (columnNames[columnIndex].equals("状态"))
			return comLis.get(rowIndex).getState();
		return null;
	}

}
