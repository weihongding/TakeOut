package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Food;
import entity.Otof;
import service.FoodService;

public class OrderFoodTableModel extends AbstractTableModel {

	String[] columnNames = { "����", "����", "�۸�" };
	List<Otof> otoflist;

	public static OrderFoodTableModel instance = new OrderFoodTableModel();

	public OrderFoodTableModel() {
		this.otoflist = null;
	}

	public OrderFoodTableModel(List<Otof> otoflist) {
		this.otoflist = otoflist;
	}

	@Override
	public int getRowCount() {
		return otoflist.size();
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
		Food food = FoodService.get(otoflist.get(rowIndex).getFid());
		if (columnNames[columnIndex].equals("����")) {
			if (food == null)
				return "���¼ܲ�Ʒ";
			return food.getName();
		}
		if (columnNames[columnIndex].equals("�۸�"))
			return otoflist.get(rowIndex).getSum_price();
		if (columnNames[columnIndex].equals("����"))
			return otoflist.get(rowIndex).getCount();
		return null;
	}

}
