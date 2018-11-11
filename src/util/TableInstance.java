package util;

import javax.swing.JTable;

import gui.model.BusLisTableModel;
import gui.model.CusComTableModel;
import gui.model.MenuTableModel;
import gui.model.OrderTableModel;

/**
 * ���������
 * 
 * @���� ��ΰ��
 *
 */
public class TableInstance {

	//����Ա
	public static JTable instance_bus_up = new JTable(BusLisTableModel.instance_up);
	public static JTable instance_bus_down = new JTable(BusLisTableModel.instance_down);
	public static JTable instance_bus_app = new JTable(BusLisTableModel.instance_app);
	public static JTable instance_com_m = new JTable(CusComTableModel.instance_m);
	
	//�˿�
	public static JTable instance_bus_c = new JTable(BusLisTableModel.instance_up);
	public static JTable instance_order_c = new JTable(OrderTableModel.instance_c);
	public static JTable instance_com_c = new JTable(CusComTableModel.instance_c);
	
	//�̼�
	public static JTable instance_order_b = new JTable(OrderTableModel.instance_b);
	
	private TableInstance() {
		// TODO Auto-generated constructor stub
	}
}
