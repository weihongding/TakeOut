package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Business;
import entity.Order;
import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.FrameAdd.OrderBusi;
import gui.FrameAdd.OrderCar;
import gui.FrameAdd.OrderFood;
import gui.FrameAdd.OrderFrame;
import gui.model.MenuTableModel;
import gui.model.OrderCarTableModel;
import service.OrderService;
import util.CheckUtil;
import util.GUIUtil;
import util.TableInstance;

public class FrameAddListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton b = (JButton) e.getSource();// ��ȡ��ť

		if (b == OrderBusi.instance.bPlace) {// �̼Ҳ˵� �µ�
			if (GUIUtil.getSum(new OrderCarTableModel(), 1, 2) == 0) {
				JOptionPane.showMessageDialog(null, "û��ѡ���Ʒ���µ�ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				OrderCar.instance = new OrderCar();
				OrderCar.instance.setVisible(true);
			}
		}
		if (b == OrderBusi.instance.bSee) {// �̼Ҳ˵� �鿴��Ʒ����
			int i = OrderBusi.instance.t.getSelectedRow();
			if (i != -1) {
				OrderFood.instance = new OrderFood((String) OrderBusi.instance.m.getValueAt(i, 0),
						(Double) OrderBusi.instance.m.getValueAt(i, 1),
						GUIUtil.getImgPath(GUIUtil.c_bid, (String) OrderBusi.instance.m.getValueAt(i, 0)));
				OrderFood.instance.jtf.setText(Integer.toString((int) OrderBusi.instance.m.getValueAt(i, 2)));
				OrderFood.instance.setVisible(true);
			}
		}
		if (b == OrderFood.instance.bSave) {// �̼Ҳ�Ʒ ȷ������
			int i = OrderBusi.instance.t.getSelectedRow();
			String num = OrderFood.instance.jtf.getText();
			if (i != -1) {
				if (CheckUtil.isNumeric(num)) {
					if (Double.parseDouble(num) >= 20) {
						JOptionPane.showMessageDialog(null, "���ε�Ʒ�������20����������ϵ�̼ң�", "����", JOptionPane.ERROR_MESSAGE);
					} else {
						MenuTableModel.num[i] = Integer.parseInt(num);
						OrderBusi.instance.setVisible(false);
						OrderFood.instance.setVisible(false);
						OrderBusi.instance.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��Ʒ����ֻ������Ȼ����", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (b == OrderCar.instance.bPlace) {// ���ﳵ �µ�
			String[][] str = GUIUtil.getArray_String(OrderBusi.instance.m, OrderBusi.instance.m.num);
			boolean flag = OrderService.add(GUIUtil.c_bid, GUIUtil.cus_id, str);
			if (flag) {
				JOptionPane.showMessageDialog(null, "�µ��ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				OrderCar.instance.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "�µ�ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (b == OrderCar.instance.bQuit) {
			OrderCar.instance.setVisible(false);
		}
		if (b == OrderFrame.instance_c.bPlace) {
			OrderFrame.instance_c.setVisible(false);
		}
		if (b == OrderFrame.instance_b.bPlace) {
			OrderFrame.instance_b.setVisible(false);
		}
	}

}
