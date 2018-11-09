package gui.FrameMain;

import javax.swing.JFrame;

import gui.panel.CustomerPanel;

/**
 * �̼���ҳ��
 * 
 * @���� ��ΰ��
 *
 */
public class CustomerFrame extends JFrame {
	
	public static CustomerFrame instance = new CustomerFrame();
	
	private CustomerFrame(){
		this.setSize(500,450);
		this.setTitle("�˿ͽ���");
		this.setContentPane(CustomerPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
