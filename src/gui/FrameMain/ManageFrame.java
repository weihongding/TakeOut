package gui.FrameMain;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.panel.ManagePanel;

/**
 * 管理员主页面
 * 
 * @作者 丁伟宏
 *
 */
public class ManageFrame extends JFrame{

	public static ManageFrame instance = new ManageFrame();
	
	private ManageFrame(){
		this.setSize(500,450);
		this.setTitle("管理员界面");
		this.setContentPane(ManagePanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}
	
}
