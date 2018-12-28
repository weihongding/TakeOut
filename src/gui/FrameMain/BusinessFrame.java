package gui.FrameMain;

import javax.swing.JFrame;

import gui.panel.BusinessPanel;
import util.GUIUtil;

public class BusinessFrame extends JFrame {
	static {
		GUIUtil.useLNF();
	}
	public static BusinessFrame instance = new BusinessFrame();

	private BusinessFrame() {
		this.setSize(600, 550);
		this.setTitle("�̼ҽ���");
		this.setContentPane(BusinessPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}

}
