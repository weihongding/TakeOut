package gui.FrameAdd;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.FrameAddListener;
import gui.model.MenuTableModel;
import service.BusinessService;
import util.GUIUtil;
import util.TableInstance;

/**
 * �˿Ͳ鿴�̼�ҳ��
 * 
 * @���� ��ΰ��
 *
 */
public class OrderBusi extends JFrame {
	static {
		GUIUtil.useLNF();
	}
	public static OrderBusi instance = new OrderBusi(GUIUtil.c_bid);
	public JButton bSee = new JButton("�鿴");
	public JButton bPlace = new JButton("�µ�");
	public JPanel pSubmit = new JPanel();
	public JScrollPane sp;
	public MenuTableModel m;
	public JTable t;

	public OrderBusi(int bid) {
		m = new MenuTableModel(bid);
		t = new JTable(m);
		sp = new JScrollPane(t);
		pSubmit.add(bSee);
		pSubmit.add(bPlace);
		this.setTitle(BusinessService.get(GUIUtil.c_bid).getName());
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
