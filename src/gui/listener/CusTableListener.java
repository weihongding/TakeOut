package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entity.Business;
import gui.FrameAdd.OrderBusi;
import gui.model.BusLisTableModel;
import gui.model.CusComTableModel;
import gui.model.OrderTableModel;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import service.BusinessService;
import util.TableInstance;

/**
 * �˿ͱ������
 * 
 * @���� ��ΰ��
 *
 */
public class CusTableListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		C_BusLisPanel cblp = C_BusLisPanel.instance;// �̼��б�
		C_OrdLisPanel colp = C_OrdLisPanel.instance;// �����б�
		C_ComPanel ccp = C_ComPanel.instance;// Ͷ�߽���
		C_MyPanel cmp = C_MyPanel.instance;// ������ҳ

		JButton b = (JButton) e.getSource();

		if (b == cblp.bSee) {
			int i = TableInstance.instance_bus_c.getSelectedRow();
			String bname = (String)BusLisTableModel.instance_up.getValueAt(i, 0);
			int bid = BusinessService.getid(bname);
			if (i != -1)
			OrderBusi.instance = new OrderBusi(bid);
			OrderBusi.instance.setVisible(true);
		}
		if (b == colp.bSee) {
			int i = TableInstance.instance_order_c.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴�˶�����" + OrderTableModel.instance_c.getValueAt(i, 0));
		}
		if (b == ccp.bSee) {
			int i = TableInstance.instance_com_c.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴��Ͷ�߽��飺" + CusComTableModel.instance_c.getValueAt(i, 0));
		}
		if (b == ccp.bAdd) {
			System.out.println("����Ͷ�߽���");
		}

	}

}