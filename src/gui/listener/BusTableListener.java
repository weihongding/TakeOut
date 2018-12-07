package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Food;
import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.model.MenuTableModel;
import gui.model.OrderTableModel;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import service.FoodService;
import util.GUIUtil;
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

		if (b == bolp.bSee) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴�˶���" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bolp.bRece) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("�����˶���" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bolp.bReje) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("�ܽ��˶���" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bmlp.bAdd) {// ���Ӳ�Ʒ
			MenuAddFrame.instance.clean();
			MenuAddFrame.instance.setVisible(true);
		}
		if (b == bmlp.bMod) {// �˵��޸�
			int i = bmlp.t.getSelectedRow();
			Food food = FoodService.get(GUIUtil.bus_id, (String) MenuTableModel.instance1.getValueAt(i, 0));
			if (i != -1) {
				MenuModFrame.instance = new MenuModFrame(food);
				MenuModFrame.instance.setVisible(true);
			}
		}
		if (b == bmlp.bDel) {// ɾ����Ʒ
			int i = bmlp.t.getSelectedRow();
			if (i != -1)
				System.out.println("ɾ���˲�Ʒ" + MenuTableModel.instance1.getValueAt(i, 0));
		}

	}

}
