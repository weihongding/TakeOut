package gui.FrameMain;

import javax.swing.JFrame;

import gui.panel.CustomerPanel;

/**
 * 商家主页面
 * 
 * @作者 丁伟宏
 *
 */
public class CustomerFrame extends JFrame {

	public static CustomerFrame instance = new CustomerFrame();

	private CustomerFrame() {
		this.setSize(500, 450);
		this.setTitle("顾客界面");
		this.setContentPane(CustomerPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
