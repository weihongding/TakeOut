package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Order;
import service.BusinessService;
import service.CustomerService;
import service.OrderService;
import util.GUIUtil;

/**
 * 订单表模型
 * 
 * @作者 丁伟宏
 *
 */
public class OrderTableModel extends AbstractTableModel {

	String[] columnNames;
	List<Order> ordlis;

	static String[] columnNames1 = { "商家", "时间", "状态" ,"总价"};
	static String[] columnNames2 = { "顾客", "时间", "状态" ,"总价"};

	public static OrderTableModel instance_c = new OrderTableModel(columnNames1, OrderService.get("customer", GUIUtil.cus_id));
	public static OrderTableModel instance_b = new OrderTableModel(columnNames2, OrderService.get("business", GUIUtil.bus_id));

	private OrderTableModel(String[] col, List<Order> list) {
		this.columnNames = col;
		this.ordlis = list;
	}
	
	public void setOrdlis(List<Order> list){
		this.ordlis = list;
	}

	public static void main(String[] args) {
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return ordlis.size();
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnNames[columnIndex].equals("商家"))
			return BusinessService.get(ordlis.get(rowIndex).getBid()).getName();
		if (columnNames[columnIndex].equals("顾客"))
			return CustomerService.get(ordlis.get(rowIndex).getCid()).getName();
		if (columnNames[columnIndex].equals("时间"))
			return ordlis.get(rowIndex).getTime();
		if (columnNames[columnIndex].equals("状态"))
			return ordlis.get(rowIndex).getState();
		if (columnNames[columnIndex].equals("总价"))
			return ordlis.get(rowIndex).getTotal_price();

		return null;
	}

}
