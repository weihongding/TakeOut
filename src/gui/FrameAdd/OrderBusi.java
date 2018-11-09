package gui.FrameAdd;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.FrameAddListener;
import gui.model.MenuTableModel;
import util.GUIUtil;
import util.TableInstance;

/**
 * 顾客查看商家页面
 * 
 * @作者 丁伟宏
 *
 */
public class OrderBusi extends JFrame {

	public static OrderBusi instance = new OrderBusi();
	public JButton bSee = new JButton("查看");
	public JButton bPlace = new JButton("下单");
	public JPanel pSubmit = new JPanel();
	public JScrollPane sp;
	public JTable t;

	private OrderBusi() {
		t = TableInstance.instance_orBus_c;
		sp = new JScrollPane(t);
		pSubmit.add(bSee);
		pSubmit.add(bPlace);
		this.setTitle("未命名食堂");
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);

		addListener();

	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}

	public void addListener() {
		FrameAddListener listener = new FrameAddListener();
		bSee.addActionListener(listener);
		bPlace.addActionListener(listener);
	}

}
