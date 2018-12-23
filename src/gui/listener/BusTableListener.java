package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Food;
import entity.Order;
import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.FrameAdd.OrderFrame;
import gui.model.MenuTableModel;
import gui.model.OrderTableModel;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import service.BusinessService;
import service.CustomerService;
import service.FoodService;
import service.OrderService;
import util.DateUtil;
import util.GUIUtil;
import util.StateUtil;
import util.TableInstance;

/**
 * �̼ұ�����
 * 
 * @���� ��ΰ��
 *
 */
public class BusTableListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		B_MenLisPanel bmlp = B_MenLisPanel.instance;// �˵��б�
		B_OrdLisPanel bolp = B_OrdLisPanel.instance;// �����б�
		B_EarnPanel bep = B_EarnPanel.instance;// �������
		B_MyPanel bmp = B_MyPanel.instance;// ������ҳ

		JButton b = (JButton) e.getSource();

		if (b == bolp.bSee) {//�鿴����
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1) {
				int cid = CustomerService.getid((String) OrderTableModel.instance_b.getValueAt(i, 0));
				Date time = DateUtil.stringToDate((String) OrderTableModel.instance_b.getValueAt(i, 1));
				Order order = OrderService.get(GUIUtil.bus_id, cid, time);
				OrderFrame.instance_b = new OrderFrame(order);
				OrderFrame.instance_b.setVisible(true);
			}
		}
		if (b == bolp.bRece) {//�ӵ�
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1) {
				int cid = CustomerService.getid((String) OrderTableModel.instance_b.getValueAt(i, 0));
				Date time = DateUtil.stringToDate((String) OrderTableModel.instance_b.getValueAt(i, 1));
				Order order = OrderService.get(GUIUtil.bus_id, cid, time);
				order.setState(StateUtil.order[1]);
				OrderService.update(order);
				bolp.updateData();
			}
		}
		if (b == bolp.bReje) {//�ʹ�
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1) {
				int cid = CustomerService.getid((String) OrderTableModel.instance_b.getValueAt(i, 0));
				Date time = DateUtil.stringToDate((String) OrderTableModel.instance_b.getValueAt(i, 1));
				Order order = OrderService.get(GUIUtil.bus_id, cid, time);
				order.setState(StateUtil.order[2]);
				OrderService.update(order);
				bolp.updateData();
			}
		}
		if (b == bmlp.bAdd) {// ���Ӳ�Ʒ
			MenuAddFrame.instance.clean();
			MenuAddFrame.instance.setVisible(true);
		}
		if (b == bmlp.bMod) {// ��Ʒ�޸�
			int i = bmlp.t.getSelectedRow();
			if (i != -1) {
				Food food = FoodService.get(GUIUtil.bus_id, (String) MenuTableModel.instance1.getValueAt(i, 0));
				MenuModFrame.instance = new MenuModFrame(food);
				MenuModFrame.instance.setVisible(true);
			}
		}
		if (b == bmlp.bDel) {// ɾ����Ʒ
			int i = bmlp.t.getSelectedRow();
			if (i != -1) {
				Food food = FoodService.get(GUIUtil.bus_id, (String) MenuTableModel.instance1.getValueAt(i, 0));
				FoodService.delete(food);
				JOptionPane.showMessageDialog(null, "�ɹ�ɾ����Ʒ��" + food.getName(), "��ʾ", JOptionPane.PLAIN_MESSAGE);
				bmlp.updateData();
			}
		}

	}

}
