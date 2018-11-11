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
				System.out.println("查看了订单：" + OrderTableModel.instance_c.getValueAt(i, 0));
		}
		if (b == ccp.bSee) {
			int i = TableInstance.instance_com_c.getSelectedRow();
			if (i != -1)
				System.out.println("查看了投诉建议：" + CusComTableModel.instance_c.getValueAt(i, 0));
		}
		if (b == ccp.bAdd) {
			System.out.println("新增投诉建议");
		}

	}

}
