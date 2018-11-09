package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.GUIUtil;

/**
 * 增加菜品
 * 
 * @作者 丁伟宏
 *
 */
public class MenuAddFrame extends JFrame {

	public JLabel[] jl = new JLabel[2];
	public JPanel[] jp = new JPanel[3];
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JTextField[] jtf = new JTextField[2];
	public JButton bIcon = new JButton("选择新图片");
	public JButton bSave = new JButton("保存");

	public MenuAddFrame() {
		jl[0] = new JLabel("菜名：");
		jl[1] = new JLabel("价格：");
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
		}

		jtf[0] = new JTextField(10);
		jtf[1] = new JTextField(10);

		jp[0].add(jl[0]);
		jp[0].add(jtf[0]);
		jp[0].setLayout(new GridLayout(1, 2));
		jp[1].add(jl[1]);
		jp[1].add(jtf[1]);
		jp[1].setLayout(new GridLayout(1, 2));
		jp[2].add(bIcon);

		for (int i = 0; i < 3; i++) {
			pCent.add(jp[i]);
		}
		pSout.add(bSave);
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);

		addListener();
	}

	public static void main(String[] args) {
		new MenuAddFrame().setVisible(true);
	}

	public void addListener() {

	}

}
