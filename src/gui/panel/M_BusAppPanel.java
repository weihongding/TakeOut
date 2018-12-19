package gui.panel;

import java.awt.BorderLayout;
import java.util.Locale.Category;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import gui.listener.ManaTableListener;
import gui.model.BusLisTableModel;
import service.ApplyService;
import util.GUIUtil;
import util.TableInstance;

/**
 * 上架申请
 * 
 * @see 管理员子页面
 * @作者 丁伟宏
 *
 */
public class M_BusAppPanel extends WorkingPanel {
	public static M_BusAppPanel instance = new M_BusAppPanel();

	public JButton bSee = new JButton("查看");
	public JButton bAdopt = new JButton("通过");
	public JButton bReject = new JButton("驳回");
	public JTable t = TableInstance.instance_bus_app;
	public JScrollPane sp;

	private M_BusAppPanel() {
		sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bAdopt);
		pSubmit.add(bReject);
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
		BusLisTableModel.instance_app.setArray(ApplyService.list());
		t = TableInstance.instance_bus_app;
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		ManaTableListener listener = new ManaTableListener();
		bSee.addActionListener(listener);
		bAdopt.addActionListener(listener);
		bReject.addActionListener(listener);
	}

}
