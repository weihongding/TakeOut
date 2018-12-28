package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.FrameAddListener;
import gui.listener.MenuListener;
import util.GUIUtil;

/**
 * ���Ӳ�Ʒ
 * 
 * @���� ��ΰ��
 *
 */
public class MenuAddFrame extends JFrame {
	static {
		GUIUtil.useLNF();
	}
	public static MenuAddFrame instance = new MenuAddFrame();
	public JLabel[] jl = new JLabel[2];
	public JPanel[] jp = new JPanel[3];
	public JLabel jicon = new JLabel();
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JTextField[] jtf = new JTextField[2];
	public JButton bIcon = new JButton("ѡ����ͼƬ");
	public JButton bSave = new JButton("����");
	public ImageIcon icon;

	public MenuAddFrame() {
		jl[0] = new JLabel("������");
		jl[1] = new JLabel("�۸�");
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
		}

		jtf[0] = new JTextField(10);
		jtf[1] = new JTextField(10);
		icon = GUIUtil.setimgwh("img/NotImage.jpg", 150, 150);
		jicon.setIcon(icon);

		jp[0].add(jl[0]);
		jp[0].add(jtf[0]);
		jp[0].setLayout(new GridLayout(1, 2));
		jp[1].add(jl[1]);
		jp[1].add(jtf[1]);
		jp[1].setLayout(new GridLayout(1, 2));
		jp[2].add(jicon);
		jp[2].add(bIcon);

		for (int i = 0; i < 3; i++) {
			pCent.add(jp[i]);
		}
		pSout.add(bSave);
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(450, 400);
		this.setLocation(800, 400);

		addListener();
	}

	public void clean() {
		jtf[0].setText("");
		jtf[1].setText("");
		icon = GUIUtil.setimgwh("img/NotImage.jpg", 150, 150);
		jicon.setIcon(icon);
	}

	public static void main(String[] args) {
		new MenuAddFrame().setVisible(true);
	}

	public void updateDate(String imgpath) {
		icon = GUIUtil.setimgwh(imgpath, 150, 150);
		jicon.setIcon(icon);
	}

	public void addListener() {
		MenuListener listener = new MenuListener();
		bIcon.addActionListener(listener);
		bSave.addActionListener(listener);
	}

}
