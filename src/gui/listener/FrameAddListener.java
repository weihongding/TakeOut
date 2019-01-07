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

		JButton b = (JButton) e.getSource();// 获取按钮

		if (b == OrderBusi.instance.bPlace) {// 商家菜单 下单
			if (GUIUtil.getSum(new OrderCarTableModel(), 1, 2) == 0) {
				JOptionPane.showMessageDialog(null, "没有选择餐品，下单失败！", "错误", JOptionPane.ERROR_MESSAGE);
			} else {
				OrderCar.instance = new OrderCar();
				OrderCar.instance.setVisible(true);
			}
		}
		if (b == OrderBusi.instance.bSee) {// 商家菜单 查看菜品详情
			int i = OrderBusi.instance.t.getSelectedRow();
			if (i != -1) {
				OrderFood.instance = new OrderFood((String) OrderBusi.instance.m.getValueAt(i, 0),
						(Double) OrderBusi.instance.m.getValueAt(i, 1),
						GUIUtil.getImgPath(GUIUtil.c_bid, (String) OrderBusi.instance.m.getValueAt(i, 0)));
				OrderFood.instance.jtf.setText(Integer.toString((int) OrderBusi.instance.m.getValueAt(i, 2)));
				OrderFood.instance.setVisible(true);
			}
		}
		if (b == OrderFood.instance.bSave) {// 商家菜品 确定数量
			int i = OrderBusi.instance.t.getSelectedRow();
			String num = OrderFood.instance.jtf.getText();
			if (i != -1) {
				if (CheckUtil.isNumeric(num)) {
					if (Double.parseDouble(num) >= 20) {
						JOptionPane.showMessageDialog(null, "单次单品如需大于20件请自行联系商家！", "错误", JOptionPane.ERROR_MESSAGE);
					} else {
						MenuTableModel.num[i] = Integer.parseInt(num);
						OrderBusi.instance.setVisible(false);
						OrderFood.instance.setVisible(false);
						OrderBusi.instance.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "菜品数量只能是自然数！", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (b == OrderCar.instance.bPlace) {// 购物车 下单
			String[][] str = GUIUtil.getArray_String(OrderBusi.instance.m, OrderBusi.instance.m.num);
			boolean flag = OrderService.add(GUIUtil.c_bid, GUIUtil.cus_id, str);
			if (flag) {
				JOptionPane.showMessageDialog(null, "下单成功！", "提示", JOptionPane.PLAIN_MESSAGE);
				OrderCar.instance.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "下单失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
