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
import gui.panel.M_BusLisPanel_down;
import gui.panel.M_BusLisPanel_up;
import gui.panel.M_CusComPanel;
import gui.panel.ManagePanel;

/**
 * 监听用户点击的按钮，更新中央面板
 * 
 * @作者 丁伟宏
 *
 */
public class ToolBarListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		ManagePanel mp = ManagePanel.instance;
		CustomerPanel cp = CustomerPanel.instance;
		BusinessPanel bp = BusinessPanel.instance;
		
		JButton b = (JButton) e.getSource();
		
		//判断管理员用户操作
		if(b == mp.bBusApp){
			mp.workingPanel.show(M_BusAppPanel.instance);
		}
		if(b == mp.bBusLis_up){
			mp.workingPanel.show(M_BusLisPanel_up.instance);
		}
		if(b == mp.bBusLis_down){
			mp.workingPanel.show(M_BusLisPanel_down.instance);
		}
		if(b == mp.bCusCom){
			mp.workingPanel.show(M_CusComPanel.instance);
		}
		
		//判断顾客用户操作
		if(b == cp.bBusLis){
			cp.workingPanel.show(C_BusLisPanel.instance);
		}
		if(b == cp.bOrdLis){
			cp.workingPanel.show(C_OrdLisPanel.instance);
		}
		if(b == cp.bComplain){
			cp.workingPanel.show(C_ComPanel.instance);
		}
		if(b == cp.bMy){
			cp.workingPanel.show(C_MyPanel.instance);
		}
		if(b == C_MyPanel.instance.bMod){
			cp.workingPanel.show(C_MyModPanel.instance);
		}
		if(b == C_MyModPanel.instance.bSave){
			System.out.println("保存信息：");
			for(int i=0;i<4;i++){
				System.out.println(C_MyModPanel.instance.jl[i].getText()+""+C_MyModPanel.instance.jtf[i].getText());
			}
			cp.workingPanel.show(C_MyPanel.instance);
		}
		
		//判断商家用户操作
		if(b == bp.bMenLis){
			bp.workingPanel.show(B_MenLisPanel.instance);
		}
		if(b == bp.bOrdLis){
			bp.workingPanel.show(B_OrdLisPanel.instance);
		}
		if(b == bp.bEarn){
			bp.workingPanel.show(B_EarnPanel.instance);
		}
		if(b == bp.bMy){
			bp.workingPanel.show(B_MyPanel.instance);
		}
		if(b == B_MyPanel.instance.bMod){
			bp.workingPanel.show(B_MyModPanel.instance);
		}
		if(b == B_MyModPanel.instance.bSave){
			System.out.println("保存信息：");
			for(int i=0;i<4;i++){
				System.out.println(B_MyModPanel.instance.jl[i].getText()+""+B_MyModPanel.instance.jtf[i].getText());
			}
			bp.workingPanel.show(B_MyPanel.instance);
		}
	}
}