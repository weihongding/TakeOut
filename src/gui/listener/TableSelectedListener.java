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
public class TableSelectedListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		// ��ȡÿ�����ĵ���

		// ����Ա
		M_BusLisPanel_up mblp_up = M_BusLisPanel_up.instance;// �ϼ��е��̼�
		M_BusLisPanel_down mblp_down = M_BusLisPanel_down.instance;// �¼��е��̼�
		M_BusAppPanel mbap = M_BusAppPanel.instance;// �����ϼܵ��̼�
		M_CusComPanel mccp = M_CusComPanel.instance;// Ͷ�߽���
		// �˿�
		C_BusLisPanel cblp = C_BusLisPanel.instance;// �̼��б�
		C_OrdLisPanel colp = C_OrdLisPanel.instance;// �����б�
		C_ComPanel ccp = C_ComPanel.instance;// Ͷ�߽���
		C_MyPanel cmp = C_MyPanel.instance;// ������ҳ
		// �̼�
		B_MenLisPanel bmlp = B_MenLisPanel.instance;// �˵��б�
		B_OrdLisPanel bolp = B_OrdLisPanel.instance;// �����б�
		B_EarnPanel bep = B_EarnPanel.instance;// �������
		B_MyPanel bmp = B_MyPanel.instance;// ������ҳ

		JButton b = (JButton) e.getSource();// ��ȡ��ť

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

		// �˿���ҳ�����
		if (b == cblp.bSee) {
			int i = TableInstance.instance_bus_c.getSelectedRow();
			if (i != -1)
				System.out.println("�鿴���̼ң�" + BusLisTableModel.instance_up.getValueAt(i, 0));
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

		// �̼���ҳ�����
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
			new MenuAddFrame().setVisible(true);
		}
		if (b == bmlp.bMod) {// �˵��޸�
			int i = bmlp.t.getSelectedRow();
			if (i != -1) {
				MenuModFrame.instance = new MenuModFrame((String) MenuTableModel.instance1.getValueAt(i, 0),
						Double.parseDouble((String) MenuTableModel.instance1.getValueAt(i, 1)), "img/1.jpg");
				MenuModFrame.instance.setVisible(true);
			}
		}
		if (b == bmlp.bDel) {// ɾ����Ʒ
			int i = bmlp.t.getSelectedRow();
			if (i != -1)
				System.out.println("ɾ���˲�Ʒ" + MenuTableModel.instance1.getValueAt(i, 0));
			bmlp.updateData();
		}

	}

}
