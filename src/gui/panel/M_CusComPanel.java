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

import gui.listener.TableSelectedListener;
import gui.model.CusComTableModel;
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

	private M_CusComPanel() {
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
