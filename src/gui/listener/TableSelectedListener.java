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
 * 表格选择监听器
 * 
 * @作者 丁伟宏
 *
 */
public class TableSelectedListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		// 获取每个面板的单例

		// 管理员
		M_BusLisPanel_up mblp_up = M_BusLisPanel_up.instance;// 上架中的商家
		M_BusLisPanel_down mblp_down = M_BusLisPanel_down.instance;// 下架中的商家
		M_BusAppPanel mbap = M_BusAppPanel.instance;// 申请上架的商家
		M_CusComPanel mccp = M_CusComPanel.instance;// 投诉建议
		// 顾客
		C_BusLisPanel cblp = C_BusLisPanel.instance;// 商家列表
		C_OrdLisPanel colp = C_OrdLisPanel.instance;// 订单列表
		C_ComPanel ccp = C_ComPanel.instance;// 投诉建议
		C_MyPanel cmp = C_MyPanel.instance;// 个人主页
		// 商家
		B_MenLisPanel bmlp = B_MenLisPanel.instance;// 菜单列表
		B_OrdLisPanel bolp = B_OrdLisPanel.instance;// 订单列表
		B_EarnPanel bep = B_EarnPanel.instance;// 收入情况
		B_MyPanel bmp = B_MyPanel.instance;// 个人主页

		JButton b = (JButton) e.getSource();// 获取按钮

		// 管理员子页面监听
		if (b == mblp_up.bSee) {
			int i = TableInstance.instance_bus_up.getSelectedRow();
			if (i != -1)
				System.out.println("查看了商家:" + BusLisTableModel.instance_up.getValueAt(i, 0));
		}
		if (b == mblp_up.bDown) {
			int i = TableInstance.instance_bus_up.getSelectedRow();
			if (i != -1)
				System.out.println("下架了商家:" + BusLisTableModel.instance_up.getValueAt(i, 0));
		}
		if (b == mblp_down.bSee) {
			int i = TableInstance.instance_bus_down.getSelectedRow();
			if (i != -1)
				System.out.println("查看了商家:" + BusLisTableModel.instance_down.getValueAt(i, 0));
		}
		if (b == mblp_down.bUp) {
			int i = TableInstance.instance_bus_down.getSelectedRow();
			if (i != -1)
				System.out.println("上架了商家:" + BusLisTableModel.instance_down.getValueAt(i, 0));
		}
		if (b == mbap.bSee) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("查看了商家:" + BusLisTableModel.instance_app.getValueAt(i, 0));
		}
		if (b == mbap.bAdopt) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("通过了商家[" + BusLisTableModel.instance_app.getValueAt(i, 0) + "]的上架申请");
		}
		if (b == mbap.bReject) {
			int i = TableInstance.instance_bus_app.getSelectedRow();
			if (i != -1)
				System.out.println("驳回了商家[" + BusLisTableModel.instance_app.getValueAt(i, 0) + "]的上架申请");
		}
		if (b == mccp.bSee) {
			int i = TableInstance.instance_com_m.getSelectedRow();
			if (i != -1)
				System.out.println("查看了投诉建议：" + CusComTableModel.instance_m.getValueAt(i, 0));
		}

		// 顾客子页面监听
		if (b == cblp.bSee) {
			int i = TableInstance.instance_bus_c.getSelectedRow();
			if (i != -1)
				System.out.println("查看了商家：" + BusLisTableModel.instance_up.getValueAt(i, 0));
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

		// 商家子页面监听
		if (b == bolp.bSee) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("查看了订单" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bolp.bRece) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("接收了订单" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bolp.bReje) {
			int i = TableInstance.instance_order_b.getSelectedRow();
			if (i != -1)
				System.out.println("拒接了订单" + OrderTableModel.instance_b.getValueAt(i, 0));
		}
		if (b == bmlp.bAdd) {// 增加菜品
			new MenuAddFrame().setVisible(true);
		}
		if (b == bmlp.bMod) {// 菜单修改
			int i = bmlp.t.getSelectedRow();
			if (i != -1) {
				MenuModFrame.instance = new MenuModFrame((String) MenuTableModel.instance1.getValueAt(i, 0),
						Double.parseDouble((String) MenuTableModel.instance1.getValueAt(i, 1)), "img/1.jpg");
				MenuModFrame.instance.setVisible(true);
			}
		}
		if (b == bmlp.bDel) {// 删除菜品
			int i = bmlp.t.getSelectedRow();
			if (i != -1)
				System.out.println("删除了菜品" + MenuTableModel.instance1.getValueAt(i, 0));
			bmlp.updateData();
		}

	}

}
