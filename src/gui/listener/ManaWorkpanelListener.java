package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import gui.FrameMain.ManageFrame;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyModPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import gui.panel.BusinessPanel;
import gui.panel.C_BusLisPanel;
import gui.panel.C_ComPanel;
import gui.panel.C_MyModPanel;
import gui.panel.C_MyPanel;
import gui.panel.C_OrdLisPanel;
import gui.panel.CustomerPanel;
import gui.panel.M_BusAppPanel;
import gui.panel.M_BusLisPanel;
import gui.panel.M_CusComPanel;
import gui.panel.ManagePanel;

/**
 * 监听用户点击的按钮，更新中央面板
 * 
 * @作者 丁伟宏
 *
 */
public class ManaWorkpanelListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		ManagePanel mp = ManagePanel.instance;

		JButton b = (JButton) e.getSource();

		if (b == mp.bBusApp) {
			mp.workingPanel.show(M_BusAppPanel.instance);
		}
		if (b == mp.bBusLis_all) {
			mp.workingPanel.show(M_BusLisPanel.instance);
		}
		if (b == mp.bCusCom) {
			mp.workingPanel.show(M_CusComPanel.instance);
		}

	}
}