package gui.FrameMain;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.panel.ManagePanel;
import util.GUIUtil;

/**
 * ����Ա��ҳ��
 * 
 * @���� ��ΰ��
 *
 */
public class ManageFrame extends JFrame {
	static {
		GUIUtil.useLNF();
	}
	public static ManageFrame instance = new ManageFrame();

	private ManageFrame() {
		this.setSize(500, 450);
		this.setTitle("����Ա����");
		this.setContentPane(ManagePanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}

}
