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
 * 顾客查看菜品页面
 * 
 * @作者 丁伟宏
 *
 */
public class OrderFood extends JFrame {

	public static OrderFood instance;
	public JLabel[] jl = new JLabel[6];
	public JLabel jicon = new JLabel();
	public JTextField jtf = new JTextField(10);
	public JButton bSave = new JButton("确定");
	public JPanel pCent1 = new JPanel();
	public JPanel pCent2 = new JPanel();
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();

	public OrderFood(String name, Double price, String imgpath) {

		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}

		jl[0].setText("菜名：");
		jl[1].setText(name);
		jl[2].setText("价格：");
		jl[3].setText(Double.toString(price));
		jl[4].setText("数量：");
		jl[5].setText("图片：");
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

		this.setTitle("菜品详细信息");
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
		
		addListener();
		
	}

	public static void main(String[] args) {
		instance = new OrderFood("回锅肉", 10.5, "img/1.jpg");
		instance.setVisible(true);
	}

	public void addListener() {
		FrameAddListener listener = new FrameAddListener();
		bSave.addActionListener(listener);
	}

}
