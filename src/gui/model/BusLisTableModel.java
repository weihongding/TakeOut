package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.AbstractTableModel;

/**
 * �̻���ģ��
 * 
 * @���� ��ΰ��
 *
 */
public class BusLisTableModel extends AbstractTableModel {

	String[] columnNames;
	String[] buslis;

	// ģ����������
	// ��ʱ��String[]������Ժ���arraylistȡservice������
	static String[] bus_up = { "�ϼ��еĵ���1", "�ϼ��еĵ���2","�ϼ��еĵ���3"};
	static String[] bus_down = { "�¼��еĵ���1", "�¼��еĵ���2", "�¼��еĵ���3" };
	static String[] bus_app = { "�����ϼܵĵ���1" ,"�����ϼܵĵ���2"};

	static String[] columnNames1 = { "����", "���" };
	static String[] columnNames2 = { "����", "����ʱ��", "�������" };

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
		if (columnNames[columnIndex].equals("����"))
			return buslis[rowIndex];
		if (columnNames[columnIndex].equals("���"))
			return "���޼��";
		if (columnNames[columnIndex].equals("����ʱ��"))
			return "����ʱ��";
		if (columnNames[columnIndex].equals("�������"))
			return "��δ����";
		return null;
	}

}
