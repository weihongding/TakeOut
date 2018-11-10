package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyModPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import gui.panel.CustomerPanel;

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
			System.out.println("保存信息：");
			for (int i = 0; i < 4; i++) {
				System.out.println(C_MyModPanel.instance.jl[i].getText() + "" + C_MyModPanel.instance.jtf[i].getText());
			}
			cp.workingPanel.show(C_MyPanel.instance);
		}

	}

}
