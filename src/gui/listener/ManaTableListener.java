package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.FrameAdd.OrderBusi;
import gui.model.BusLisTableModel;
import gui.model.CusComTableModel;
import gui.model.MenuTableModel;
import gui.model.OrderTableModel;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import gui.panel.BusinessPanel;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import gui.panel.CustomerPanel;
import gui.panel.M_BusAppPanel;
import gui.panel.M_BusLisPanel_down;
import gui.panel.M_BusLisPanel_up;
import gui.panel.M_CusComPanel;
import gui.panel.ManagePanel;
import util.TableInstance;

/**
 * ���ѡ�������
 * 
 * @���� ��ΰ��
 *
 */
public class ManaTableListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		M_BusLisPanel_up mblp_up = M_BusLisPanel_up.instance;// �ϼ��е��̼�
		M_BusLisPanel_down mblp_down = M_BusLisPanel_down.instance;// �¼��е��̼�
		M_BusAppPanel mbap = M_BusAppPanel.instance;// �����ϼܵ��̼�
		M_CusComPanel mccp = M_CusComPanel.instance;// Ͷ�߽���

		JButton b = (JButton) e.getSource();

		// ����Ա��ҳ�����
		if (b == mblp_up.bSee) {
			int i = TableInstance.instance_bus_up.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴���̼�:" + BusLisTableModel.instance_up.getValueAt(i, 0));
		}
		if (b == mblp_up.bDown) {
			int i = TableInstance.instance_bus_up.getSelectedRow();
			if (i != -1)
				System.out.println("�¼����̼�:" + BusLisTableModel.instance_up.getValueAt(i, 0));
		}
		if (b == mblp_down.bSee) {
			int i = TableInstance.instance_bus_down.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴���̼�:" + BusLisTableModel.instance_down.getValueAt(i, 0));
		}
		if (b == mblp_down.bUp) {
			int i = TableInstance.instance_bus_down.getSelectedRow();
			if (i != -1)
				System.out.println("�ϼ����̼�:" + BusLisTableModel.instance_down.getValueAt(i, 0));
		}
		if (b == mbap.bSee) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴���̼�:" + BusLisTableModel.instance_app.getValueAt(i, 0));
		}
		if (b == mbap.bAdopt) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("ͨ�����̼�[" + BusLisTableModel.instance_app.getValueAt(i, 0) + "]���ϼ�����");
		}
		if (b == mbap.bReject) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("�������̼�[" + BusLisTableModel.instance_app.getValueAt(i, 0) + "]���ϼ�����");
		}
		if (b == mccp.bSee) {
			int i = TableInstance.instance_com_m.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴��Ͷ�߽��飺" + CusComTableModel.instance_m.getValueAt(i, 0));
		}

	}

}
