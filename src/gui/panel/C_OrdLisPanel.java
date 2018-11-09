package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.TableSelectedListener;
import util.GUIUtil;
import util.TableInstance;
/**
 * 订单列表
 * 
 * @see 顾客子页面
 * @作者 丁伟宏
 *
 */
public class C_OrdLisPanel extends WorkingPanel {
	public static C_OrdLisPanel instance = new C_OrdLisPanel();
	public JButton bSee = new JButton("查看详情");
	public JTable t = TableInstance.instance_order_c;

	private C_OrdLisPanel() {
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);

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
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener() {
		TableSelectedListener listener = new TableSelectedListener();
		bSee.addActionListener(listener);

	}

}
