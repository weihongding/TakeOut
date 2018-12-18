package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.BusTableListener;
import gui.model.OrderTableModel;
import service.OrderService;
import util.GUIUtil;
import util.TableInstance;

/**
 * 订单页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_OrdLisPanel extends WorkingPanel {
	public static B_OrdLisPanel instance = new B_OrdLisPanel();
	public JButton bSee = new JButton("查看详情");
	public JButton bRece = new JButton("接单");
	public JButton bReje = new JButton("送达");
	public JTable t = TableInstance.instance_order_b;
	public JScrollPane sp;

	private B_OrdLisPanel() {
		sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bRece);
		pSubmit.add(bReje);

		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance);
	}

	@Override
	public void updateData() {
		OrderTableModel.instance_b.setOrdlis(OrderService.get("business", GUIUtil.bus_id));
		t = TableInstance.instance_order_b;
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		BusTableListener listener = new BusTableListener();
		bSee.addActionListener(listener);
		bRece.addActionListener(listener);
		bReje.addActionListener(listener);
	}

}
