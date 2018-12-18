package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Customer;
import entity.Customer;
import gui.panel.C_MyModPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyModPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import gui.panel.CustomerPanel;
import service.CustomerService;
import service.CustomerService;
import util.CheckUtil;
import util.GUIUtil;

/**
 * 顾客子页面监听
 * 
 * @作者 丁伟宏
 *
 */
public class CusWorkpanelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		CustomerPanel cp = CustomerPanel.instance;

		JButton b = (JButton) e.getSource();

		if (b == cp.bBusLis) {
			cp.workingPanel.show(C_BusLisPanel.instance);
		}
		if (b == cp.bOrdLis) {
			cp.workingPanel.show(C_OrdLisPanel.instance);
		}
		if (b == cp.bComplain) {
			cp.workingPanel.show(C_ComPanel.instance);
		}
		if (b == cp.bMy) {
			cp.workingPanel.show(C_MyPanel.instance);
		}
		if (b == C_MyPanel.instance.bMod) {
			cp.workingPanel.show(C_MyModPanel.instance);
		}
		if (b == C_MyModPanel.instance.bSave) {
			String name = C_MyModPanel.instance.jtf[0].getText();
			String des = C_MyModPanel.instance.jtf[1].getText();
			String phone = C_MyModPanel.instance.jtf[2].getText();
			String address = C_MyModPanel.instance.jtf[3].getText();
			if (CheckUtil.phoneCheck(phone)) {
				Customer cus = CustomerService.get(GUIUtil.cus_id);
				cus.setName(name);
				cus.setDes(des);
				cus.setPhone(phone);
				cus.setAddress(address);
				CustomerService.update(cus);
				JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.PLAIN_MESSAGE);
				C_MyPanel.instance.updateData();
				cp.workingPanel.show(C_MyPanel.instance);
			} else {
				JOptionPane.showMessageDialog(null, "手机号不合法！", "", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
