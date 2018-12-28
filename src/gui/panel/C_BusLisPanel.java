package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import gui.listener.CusTableListener;
import gui.listener.ManaTableListener;
import gui.model.BusLisTableModel;
import service.BusinessService;
import util.GUIUtil;
import util.TableInstance;

/**
 * 商家列表
 * 
 * @see 顾客子页面
 * @作者 丁伟宏
 *
 */
public class C_BusLisPanel extends WorkingPanel {
	public static C_BusLisPanel instance = new C_BusLisPanel();
	public JButton bSee = new JButton("查看详情");
	public JTable t = TableInstance.instance_bus_c;
	public JScrollPane sp;

	private C_BusLisPanel() {
		sp = new JScrollPane(t);
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
		BusLisTableModel.instance_up.setArray(BusinessService.list_up());
		t = TableInstance.instance_bus_c;
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		CusTableListener listener = new CusTableListener();
		bSee.addActionListener(listener);
	}

}
