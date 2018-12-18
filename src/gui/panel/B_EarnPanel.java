package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.listener.BusTableListener;
import service.OrderService;
import util.ChartUtil;
import util.GUIUtil;

/**
 * 收入页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_EarnPanel extends WorkingPanel {

	public static B_EarnPanel instance = new B_EarnPanel();
	public JLabel jl1, jl2;

	private B_EarnPanel() {

		jl1 = new JLabel("已送达订单："+Double.toString(OrderService.earn_have(GUIUtil.bus_id)));
		jl2 = new JLabel("未送达订单："+Double.toString(OrderService.earn_will(GUIUtil.bus_id)));
		this.add(jl1);
		this.add(jl2);
		this.setLayout(new GridLayout(2, 2));

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance);
	}

	@Override
	public void updateData() {
		jl1.setText("已送达订单："+Double.toString(OrderService.earn_have(GUIUtil.bus_id)));
		jl2.setText("未送达订单："+Double.toString(OrderService.earn_will(GUIUtil.bus_id)));

	}

	@Override
	public void addListener() {
		BusTableListener listener = new BusTableListener();

	}

}
