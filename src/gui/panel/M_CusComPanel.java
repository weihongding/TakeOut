package gui.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.listener.ManaTableListener;
import gui.model.CusComTableModel;
import service.ComplainService;
import util.GUIUtil;
import util.TableInstance;

/**
 * 投诉建议
 * 
 * @see 管理员子页面
 * @作者 丁伟宏
 *
 */
public class M_CusComPanel extends WorkingPanel {
	public static M_CusComPanel instance = new M_CusComPanel();

	public JButton bSee = new JButton("查看");

	public JTable t = TableInstance.instance_com_m;
	public JScrollPane sp;

	private M_CusComPanel() {
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
		CusComTableModel.instance_m.setComlis(ComplainService.list());
		t = TableInstance.instance_com_m;
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		ManaTableListener listener = new ManaTableListener();
		bSee.addActionListener(listener);
	}

}
