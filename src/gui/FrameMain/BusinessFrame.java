package gui.FrameMain;

import javax.swing.JFrame;

import gui.panel.BusinessPanel;

public class BusinessFrame extends JFrame{

	public static BusinessFrame instance = new BusinessFrame();
	
	private BusinessFrame(){
		this.setSize(500,450);
		this.setTitle("����Ա����");
		this.setContentPane(BusinessPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}
	
	
}
