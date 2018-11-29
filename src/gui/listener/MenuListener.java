package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();// 获取按钮

		if(b == MenuAddFrame.instance.bSave){
			System.out.println("点击了确定");
		}
		if(b== MenuAddFrame.instance.bIcon){
			System.out.println("点击了选择图片");
		}
		if (b == MenuModFrame.instance.bSave) {
			System.out.println("点击了确定");
		}
		if (b == MenuModFrame.instance.bIcon) {
			System.out.println("点击了选择图片");
		}
	}

}
