package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton) e.getSource();// ��ȡ��ť

		if(b == MenuAddFrame.instance.bSave){
			System.out.println("�����ȷ��");
		}
		if(b== MenuAddFrame.instance.bIcon){
			System.out.println("�����ѡ��ͼƬ");
		}
		if (b == MenuModFrame.instance.bSave) {
			System.out.println("�����ȷ��");
		}
		if (b == MenuModFrame.instance.bIcon) {
			System.out.println("�����ѡ��ͼƬ");
		}
	}

}
