package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.OrderDao;
import entity.Order;
import entity.Otof;
import gui.listener.FrameAddListener;
import gui.model.OrderFoodTableModel;
import service.BusinessService;
import service.CustomerService;
import service.OrderService;
import util.DateUtil;
import util.GUIUtil;

public class OrderFrame extends JFrame {
	static {
		GUIUtil.useLNF();
	}

	public static OrderFrame instance_c = new OrderFrame(new OrderDao().get_last());
	public static OrderFrame instance_b = new OrderFrame(new OrderDao().get_last());
	public JLabel[] jl = new JLabel[5];
	public JPanel pTitle = new JPanel();
	public JPanel pSubmit = new JPanel();
	public JButton bPlace = new JButton("确定");
	public JScrollPane sp;
	public JTable t;

	public OrderFrame(Order order) {
		List<Otof> otoflist = OrderService.getotof(order.getId());
		jl[0] = new JLabel("店铺：" + BusinessService.get(order.getBid()).getName());
		jl[1] = new JLabel("顾客：" + CustomerService.get(order.getCid()).getName());
		jl[2] = new JLabel("下单时间：" + DateUtil.formatDate(order.getTime()));
		jl[3] = new JLabel("订单状态：" + order.getState());
		jl[4] = new JLabel("总价" + order.getTotal_price());

		OrderFoodTableModel.instance = new OrderFoodTableModel(otoflist);
		t = new JTable(OrderFoodTableModel.instance);
		sp = new JScrollPane(t);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp1.add(jl[0]);
		jp1.add(jl[1]);
		jp1.setLayout(new GridLayout(1, 2));
		jp2.add(jl[2]);
		jp3.add(jl[3]);
		pTitle.add(jp1);
		pTitle.add(jp2);
		pTitle.add(jp3);
		pTitle.setLayout(new GridLayout(3, 1));

		pSubmit.add(jl[4]);
		pSubmit.add(bPlace);

		this.setTitle("订单详情");
		this.setLayout(new BorderLayout());
		this.add(pTitle, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
		
		addListener();

	}

	public static void main(String[] args) {
		instance_b.setVisible(true);
	}

	public void addListener() {
		FrameAddListener listener = new FrameAddListener();
		bPlace.addActionListener(listener);
	}

}
