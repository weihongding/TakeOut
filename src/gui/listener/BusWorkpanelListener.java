package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyModPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import gui.panel.BusinessPanel;

/**
 * 商家子页面监听
 * 
 * @作者 丁伟宏
 *
 */
public class BusWorkpanelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		BusinessPanel bp = BusinessPanel.instance;

		JButton b = (JButton) e.getSource();

		if (b == bp.bMenLis) {
			bp.workingPanel.show(B_MenLisPanel.instance);
		}
		if (b == bp.bOrdLis) {
			bp.workingPanel.show(B_OrdLisPanel.instance);
		}
		if (b == bp.bEarn) {
			bp.workingPanel.show(B_EarnPanel.instance);
		}
		if (b == bp.bMy) {
			bp.workingPanel.show(B_MyPanel.instance);
		}
		if (b == B_MyPanel.instance.bMod) {
			bp.workingPanel.show(B_MyModPanel.instance);
		}
		if (b == B_MyModPanel.instance.bSave) {
			System.out.println("保存信息：");
			for (int i = 0; i < 4; i++) {
				System.out.println(B_MyModPanel.instance.jl[i].getText() + "" + B_MyModPanel.instance.jtf[i].getText());
			}
			bp.workingPanel.show(B_MyPanel.instance);
		}
	}

}
