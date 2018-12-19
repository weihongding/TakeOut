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
 * �̻���ģ��
 * 
 * @���� ��ΰ��
 *
 */
public class BusLisTableModel extends AbstractTableModel {

	List array = null;
	String[] columnNames = null;

	static String[] columnNames1 = { "����", "���" };
	static String[] columnNames2 = { "����", "����ʱ��", "�������" };
	static String[] columnNames3 = { "����", "״̬" };

	public static BusLisTableModel instance_up = new BusLisTableModel(columnNames1, BusinessService.list_up());
	public static BusLisTableModel instance_all = new BusLisTableModel(columnNames3, BusinessService.list_all());
	public static BusLisTableModel instance_app = new BusLisTableModel(columnNames2, ApplyService.list());

	private BusLisTableModel(String[] column, List array) {
		this.columnNames = column;
		this.array = array;
	}

	public void setArray(List array) {
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
			if (columnNames[columnIndex].equals("����"))
				return BusinessService.get(bid).getName();
			if (columnNames[columnIndex].equals("����ʱ��"))
				return DateUtil.formatDate(((Apply) array.get(rowIndex)).getTime());
			if (columnNames[columnIndex].equals("�������"))
				return ((Apply) array.get(rowIndex)).getState();
		}
		if (array.get(0) instanceof Business) {
			if (columnNames[columnIndex].equals("����"))
				return ((Business) array.get(rowIndex)).getName();
			if (columnNames[columnIndex].equals("���"))
				return ((Business) array.get(rowIndex)).getDes();
			if (columnNames[columnIndex].equals("״̬"))
				return ((Business) array.get(rowIndex)).getState();
		}

		return null;
	}

}
