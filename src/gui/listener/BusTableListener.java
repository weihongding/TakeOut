package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.model.MenuTableModel;
import gui.model.OrderTableModel;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import util.TableInstance;

/**
 * 商家表格监听
 * 
 * @作者 丁伟宏
 *
 */
public class BusTableListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		B_MenLisPanel bmlp = B_MenLisPanel.instance;// 菜单列表
		B_OrdLisPanel bolp = B_OrdLisPanel.instance;// 订单列表
		B_EarnPanel bep = B_EarnPanel.instance;// 收入情况
		B_MyPanel bmp = B_MyPanel.instance;// 个人主页

		JButton b = (JButton) e.getSource();

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
			MenuAddFrame.instance.clean();
			MenuAddFrame.instance.setVisible(true);
		}
		if (b == bmlp.bMod) {// 菜单修改
			int i = bmlp.t.getSelectedRow();
			if (i != -1) {
				MenuModFrame.instance = new MenuModFrame((String) MenuTableModel.instance1.getValueAt(i, 0),
						(Double) MenuTableModel.instance1.getValueAt(i, 1), "img/1.jpg");
				MenuModFrame.instance.setVisible(true);
			}
		}
		if (b == bmlp.bDel) {// 删除菜品
			int i = bmlp.t.getSelectedRow();
			if (i != -1)
				System.out.println("删除了菜品" + MenuTableModel.instance1.getValueAt(i, 0));
			bmlp.t = new JTable(MenuTableModel.instance1);
			bmlp.sp = new JScrollPane(bmlp.t);
		}

	}

}
