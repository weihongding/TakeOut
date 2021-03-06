package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Business;
import entity.Complain;
import entity.Order;
import gui.FrameAdd.ComplainAddFrame;
import gui.FrameAdd.ComplainFrame;
import gui.FrameAdd.OrderBusi;
import gui.FrameAdd.OrderFrame;
import gui.model.BusLisTableModel;
import gui.model.CusComTableModel;
import gui.model.OrderTableModel;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import service.BusinessService;
import service.ComplainService;
import service.CustomerService;
import service.OrderService;
import util.DateUtil;
import util.GUIUtil;
import util.TableInstance;

/**
 * 顾客表格监听
 * 
 * @作者 丁伟宏
 *
 */
public class CusTableListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		C_BusLisPanel cblp = C_BusLisPanel.instance;// 商家列表
		C_OrdLisPanel colp = C_OrdLisPanel.instance;// 订单列表
		C_ComPanel ccp = C_ComPanel.instance;// 投诉建议
		C_MyPanel cmp = C_MyPanel.instance;// 个人主页

		JButton b = (JButton) e.getSource();

		if (b == cblp.bSee) {// 查看商家详情
			int i = TableInstance.instance_bus_c.getSelectedRow();
			if (i != -1) {
				if (CustomerService.get(GUIUtil.cus_id).getAddress() == null
						|| CustomerService.get(GUIUtil.cus_id).getPhone() == null) {
					JOptionPane.showMessageDialog(null, "您的地址/电话尚未填写，无法点餐", "错误", JOptionPane.ERROR_MESSAGE);
				} else {
					String bname = (String) BusLisTableModel.instance_up.getValueAt(i, 0);
					GUIUtil.c_bid = BusinessService.getid(bname);
					OrderBusi.instance = new OrderBusi(GUIUtil.c_bid);
					OrderBusi.instance.setVisible(true);
				}
			}
		}
		if (b == colp.bSee) {// 查看订单详情
			int i = TableInstance.instance_order_c.getSelectedRow();
			if (i != -1) {
				int bid = BusinessService.getid((String) OrderTableModel.instance_c.getValueAt(i, 0));
				Date time = DateUtil.stringToDate((String) OrderTableModel.instance_c.getValueAt(i, 1));
				Order order = OrderService.get(bid, GUIUtil.cus_id, time);
				OrderFrame.instance_c = new OrderFrame(order);
				OrderFrame.instance_c.setVisible(true);
			}
		}
		if (b == ccp.bSee) {// 查看投诉建议
			int i = TableInstance.instance_com_c.getSelectedRow();
			if (i != -1) {
				Date time = DateUtil.stringToDate((String) CusComTableModel.instance_c.getValueAt(i, 0));
				Complain com = ComplainService.get(GUIUtil.cus_id, time);
				new ComplainFrame(com.getId()).setVisible(true);
				;
			}
		}
		if (b == ccp.bAdd) {// 增加投诉建议
			new ComplainAddFrame().setVisible(true);
		}

	}

}
