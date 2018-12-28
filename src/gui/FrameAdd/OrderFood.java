package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.listener.FrameAddListener;
import gui.model.MenuTableModel;
import util.GUIUtil;

/**
 * �˿Ͳ鿴��Ʒҳ��
 * 
 * @���� ��ΰ��
 *
 */
public class OrderFood extends JFrame {
	static {
		GUIUtil.useLNF();
	}
	public static OrderFood instance = new OrderFood("�ع���", 10.5, "img/NotImage.jpg");
	public JLabel[] jl = new JLabel[6];
	public JLabel jicon = new JLabel();
	public JTextField jtf = new JTextField(10);
	public JButton bSave = new JButton("ȷ��");
	public JPanel pCent1 = new JPanel();
	public JPanel pCent2 = new JPanel();
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();

	public OrderFood(String name, Double price, String imgpath) {

		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}

		jl[0].setText("������");
		jl[1].setText(name);
		jl[2].setText("�۸�");
		jl[3].setText(Double.toString(price));
		jl[4].setText("������");
		jl[5].setText("ͼƬ��");
		ImageIcon icon = GUIUtil.setimgwh(imgpath, 150, 150);
		jicon.setIcon(icon);
		for (int i = 0; i < 5; i++) {
			pCent1.add(jl[i]);
		}
		pCent1.add(jtf);

		pCent1.setLayout(new GridLayout(3, 2));
		pCent2.add(jl[5]);
		pCent2.add(jicon);

		pCent.setLayout(new BorderLayout());
		pCent.add(pCent1, BorderLayout.CENTER);
		pCent.add(pCent2, BorderLayout.SOUTH);

		pSout.add(bSave);

		this.setTitle("��Ʒ��ϸ��Ϣ");
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(450, 400);
		this.setLocation(800, 400);
		
		addListener();
		
	}

	public static void main(String[] args) {
		instance = new OrderFood("�ع���", 10.5, "img/NotImage.jpg");
		instance.setVisible(true);
	}

	public void addListener() {
		FrameAddListener listener = new FrameAddListener();
		bSave.addActionListener(listener);
	}

}
