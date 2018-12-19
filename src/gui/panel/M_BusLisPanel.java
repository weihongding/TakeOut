package gui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.listener.ManaTableListener;
import gui.model.BusLisTableModel;
import service.BusinessService;
import util.GUIUtil;
import util.TableInstance;

/**
 * 下架中的商家
 * 
 * @see 管理员子页面
 * @作者 丁伟宏
 *
 */
public class M_BusLisPanel extends WorkingPanel {
	public static M_BusLisPanel instance = new M_BusLisPanel();
	public JButton bUp = new JButton("上架");
	public JButton bDown = new JButton("下架");
	public JTable t = TableInstance.instance_bus_all;
	public JScrollPane sp;

	private M_BusLisPanel() {
		sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bUp);
		pSubmit.add(bDown);
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
		BusLisTableModel.instance_all.setArray(BusinessService.list_all());
		JTable t = TableInstance.instance_bus_all;
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		ManaTableListener listener = new ManaTableListener();
		bUp.addActionListener(listener);
		bDown.addActionListener(listener);
	}

}
