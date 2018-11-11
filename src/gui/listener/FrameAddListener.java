package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entity.Business;
import gui.FrameAdd.MenuModFrame;
import gui.FrameAdd.OrderBusi;
import gui.FrameAdd.OrderCar;
import gui.FrameAdd.OrderFood;
import gui.model.MenuTableModel;
import util.TableInstance;

public class FrameAddListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton b = (JButton) e.getSource();// 获取按钮

		if (b == OrderBusi.instance.bPlace) {
			OrderCar.instance = new OrderCar();
			OrderCar.instance.setVisible(true);
		}
		if (b == OrderBusi.instance.bSee) {
			int i = OrderBusi.instance.t.getSelectedRow();
			OrderFood.instance = new OrderFood((String)OrderBusi.instance.m.getValueAt(i, 0),(Double)OrderBusi.instance.m.getValueAt(i, 1), "img/1.jpg");
			OrderFood.instance.jtf.setText(Integer.toString((int)OrderBusi.instance.m.getValueAt(i, 2)));
			OrderFood.instance.setVisible(true);
		}
		if( b == OrderFood.instance.bSave){
			int i = OrderBusi.instance.t.getSelectedRow();
			MenuTableModel.num[i] = Integer.parseInt(OrderFood.instance.jtf.getText());
			OrderBusi.instance.setVisible(false);
			OrderFood.instance.setVisible(false);
			OrderBusi.instance.setVisible(true);
		}
		if (b == MenuModFrame.instance.bSave) {
			System.out.println("点击了确定");
		}
		if (b == MenuModFrame.instance.bIcon) {
			System.out.println("点击了选择图片");
		}

	}

}
