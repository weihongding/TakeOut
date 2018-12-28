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
	public JLabel jl = new JLabel();
	public JPanel jp = new JPanel();
	public Image img;
	public Icon icon;

	private B_EarnPanel() {

		img = ChartUtil.getImage(400, 300, OrderService.getEarn(GUIUtil.bus_id));
		icon = new ImageIcon(img);
		jl.setIcon(icon);
		jp.add(jl);

		this.add(jp);

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance);
	}

	@Override
	public void updateData() {
		img = ChartUtil.getImage(400, 300, OrderService.getEarn(GUIUtil.bus_id));
		icon = new ImageIcon(img);
		jl.setIcon(icon);
	}

	@Override
	public void addListener() {
		BusTableListener listener = new BusTableListener();

	}

}
