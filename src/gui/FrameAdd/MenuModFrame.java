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
import util.GUIUtil;

/**
 * �޸Ĳ�Ʒ��Ϣ
 * 
 * @���� ��ΰ��
 *
 */
public class MenuModFrame extends JFrame {

	public static MenuModFrame instance = new MenuModFrame("��", 10.0, "0");
	public JLabel[] jl = new JLabel[2];
	public JPanel[] jp = new JPanel[3];
	public JLabel jicon = new JLabel();
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JTextField[] jtf = new JTextField[2];
	public JButton bIcon = new JButton("ѡ����ͼƬ");
	public JButton bSave = new JButton("����");

	public MenuModFrame(String name, Double price, String imgpath) {

		jl[0] = new JLabel("������");
		jl[1] = new JLabel("�۸�");
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
		}

		jtf[0] = new JTextField(10);
		jtf[0].setText(name);
		jtf[1] = new JTextField(10);
		jtf[1].setText(Double.toString(price));
		ImageIcon icon = GUIUtil.setimgwh(imgpath, 150, 150);
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
		this.setSize(350, 300);
		this.setLocation(800, 400);

		addListener();

	}

	public static void main(String[] args) {
		instance = new MenuModFrame("�ع���", 10.5, "img/1.jpg");
		instance.setVisible(true);
	}

	public void addListener() {
		FrameAddListener listener = new FrameAddListener();
		bSave.addActionListener(listener);
		bIcon.addActionListener(listener);
	}

}
