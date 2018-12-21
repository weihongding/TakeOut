package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTable;

import entity.Apply;
import entity.Business;
import entity.Complain;
import gui.FrameAdd.ApplyFrame;
import gui.FrameAdd.ComplainFrame;
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
import gui.panel.M_BusLisPanel;
import gui.panel.M_CusComPanel;
import gui.panel.ManagePanel;
import service.ApplyService;
import service.BusinessService;
import service.ComplainService;
import util.DateUtil;
import util.GUIUtil;
import util.StateUtil;
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

		M_BusLisPanel mblp = M_BusLisPanel.instance;// �̼��б�
		M_BusAppPanel mbap = M_BusAppPanel.instance;// �����ϼܵ��̼�
		M_CusComPanel mccp = M_CusComPanel.instance;// Ͷ�߽���

		JButton b = (JButton) e.getSource();

		// ����Ա��ҳ�����
		if (b == mblp.bUp) {// �ϼ��̼�
			int i = TableInstance.instance_bus_all.getSelectedRow();
			if (i != -1) {
				String bname = (String) BusLisTableModel.instance_all.getValueAt(i, 0);
				int bid = BusinessService.getid(bname);
				Business bus = BusinessService.get(bid);
				bus.setState(StateUtil.busi[1]);
				BusinessService.update(bus);
				mblp.updateData();
			}
		}
		if (b == mblp.bDown) {// �¼��̼�
			int i = TableInstance.instance_bus_all.getSelectedRow();
			if (i != -1) {
				String bname = (String) BusLisTableModel.instance_all.getValueAt(i, 0);
				int bid = BusinessService.getid(bname);
				Business bus = BusinessService.get(bid);
				bus.setState(StateUtil.busi[0]);
				BusinessService.update(bus);
				mblp.updateData();
			}
		}
		if (b == mbap.bSee) {// �鿴�ϼ�����
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1) {
				String bname = (String) BusLisTableModel.instance_app.getValueAt(i, 0);
				int bid = BusinessService.getid(bname);
				Date time = DateUtil.stringToDate((String) BusLisTableModel.instance_app.getValueAt(i, 1));
				Apply app = ApplyService.get(bid, time);
				int aid = app.getId();
				new ApplyFrame(aid).setVisible(true);
			}
		}
		if (b == mbap.bAdopt) {// ͨ���ϼ�����
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1) {
				String bname = (String) BusLisTableModel.instance_app.getValueAt(i, 0);
				int bid = BusinessService.getid(bname);
				Business bus = BusinessService.get(bid);
				Date time = DateUtil.stringToDate((String) BusLisTableModel.instance_app.getValueAt(i, 1));
				Apply app = ApplyService.get(bid, time);
				int aid = app.getId();
				bus.setState(StateUtil.busi[1]);
				app.setState(StateUtil.apply[1]);
				ApplyService.update(app);
				BusinessService.update(bus);
				mbap.updateData();
			}
		}
		if (b == mbap.bReject) {// �����ϼ�����
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1) {
				String bname = (String) BusLisTableModel.instance_app.getValueAt(i, 0);
				int bid = BusinessService.getid(bname);
				Date time = DateUtil.stringToDate((String) BusLisTableModel.instance_app.getValueAt(i, 1));
				Apply app = ApplyService.get(bid, time);
				int aid = app.getId();
				app.setState(StateUtil.apply[2]);
				ApplyService.update(app);
				mbap.updateData();
			}
		}
		if (b == mccp.bSee) {// �鿴Ͷ�߽���
			int i = TableInstance.instance_com_m.getSelectedRow();
			if (i != -1) {
				int coid = (Integer) CusComTableModel.instance_m.getValueAt(i, 0);
				ComplainFrame.instance = new ComplainFrame(coid);
				ComplainFrame.instance.jta2.setEditable(true);
				ComplainFrame.instance.bSub.setText("�ύ");
				ComplainFrame.instance.setVisible(true);
			}
		}

	}

}
