package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Business;
import gui.FrameAdd.ApplyAddFrame;
import gui.panel.B_EarnPanel;
import gui.panel.B_MenLisPanel;
import gui.panel.B_MyModPanel;
import gui.panel.B_MyPanel;
import gui.panel.B_OrdLisPanel;
import gui.panel.BusinessPanel;
import service.BusinessService;
import util.CheckUtil;
import util.GUIUtil;
import util.StateUtil;

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
		if (b == B_MyPanel.instance.bApp) {
			String state = BusinessService.get(GUIUtil.bus_id).getState();
			if (state.equals(StateUtil.busi[1])) {
				JOptionPane.showMessageDialog(null, "您已上架，无需申请！", "", JOptionPane.ERROR_MESSAGE);
			} else {
				new ApplyAddFrame().setVisible(true);
			}
		}
		if (b == B_MyModPanel.instance.bSave) {
			String name = B_MyModPanel.instance.jtf[0].getText();
			String des = B_MyModPanel.instance.jtf[1].getText();
			String phone = B_MyModPanel.instance.jtf[2].getText();
			String address = B_MyModPanel.instance.jtf[3].getText();
			if (CheckUtil.phoneCheck(phone)) {
				Business bus = BusinessService.get(GUIUtil.bus_id);
				bus.setName(name);
				bus.setDes(des);
				bus.setPhone(phone);
				bus.setAddress(address);
				BusinessService.update(bus);
				JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.PLAIN_MESSAGE);
				B_MyPanel.instance.updateData();
				bp.workingPanel.show(B_MyPanel.instance);
			} else {
				JOptionPane.showMessageDialog(null, "手机号不合法！", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
