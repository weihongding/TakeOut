package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entity.Customer;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyModPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import gui.panel.CustomerPanel;
import service.CustomerService;
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
			String[] str = new String[4];
			for (int i = 0; i < 4; i++) {
				str[i] = C_MyModPanel.instance.jtf[i].getText();
			}
			Customer cus = new Customer(GUIUtil.cus_id, str[0], str[1], str[2], str[3]);
			CustomerService.update(cus);
			cp.workingPanel.show(C_MyPanel.instance);
		}

	}

}
