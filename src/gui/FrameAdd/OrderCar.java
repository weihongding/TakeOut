package gui.FrameAdd;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.MenuTableModel;
import gui.model.OrderCarTableModel;
import gui.model.OrderTableModel;
import service.BusinessService;
import util.GUIUtil;
import util.TableInstance;

public class OrderCar extends JFrame {

	public static OrderCar instance = new OrderCar();
	public JLabel jl1 = new JLabel();
	public JLabel jl2 = new JLabel();
	public JButton bPlace = new JButton("ȷ��");
	public JButton bQuit = new JButton("ȡ��");
	public JPanel pTitle = new JPanel();
	public JPanel pSubmit = new JPanel();
	public JScrollPane sp;
	public JTable t;

	public OrderCar() {

		jl1.setText(BusinessService.get(GUIUtil.c_bid).getName()+"�Ĺ��ﳵ");
		pTitle.add(jl1);
		OrderCarTableModel.instance = new OrderCarTableModel();
		t = new JTable(OrderCarTableModel.instance);
		jl2.setText("�ܼۣ�" + Double.toString(GUIUtil.getSum(OrderCarTableModel.instance, 1, 2)));
		sp = new JScrollPane(t);
		pSubmit.add(jl2);
		pSubmit.add(bPlace);
		pSubmit.add(bQuit);
		this.setTitle("���ﳵ");
		this.setLayout(new BorderLayout());
		this.add(pTitle, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);

		addListener();
	}

	public static void main(String[] args) {
		MenuTableModel.num[0] = 2;
		instance = new OrderCar();
		instance.setVisible(true);
	}
	
	public void addListener() {
		// TODO Auto-generated method stub

	}

}
