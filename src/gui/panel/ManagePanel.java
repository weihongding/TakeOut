package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import gui.listener.ManaWorkpanelListener;
import util.CenterPanel;
import util.GUIUtil;

/**
 * 管理员页面主模版
 * 
 * @作者 丁伟宏
 *
 */
public class ManagePanel extends JPanel {

	public static ManagePanel instance = new ManagePanel();
	public JToolBar tb = new JToolBar();
	public JButton bBusApp = new JButton("上架申请");
	public JButton bBusLis_all = new JButton("商家列表");
	public JButton bCusCom = new JButton("投诉建议");
	public CenterPanel workingPanel;

	private ManagePanel() {
		tb.add(bBusApp);
		tb.add(bBusLis_all);
		tb.add(bCusCom);
		tb.setFloatable(false);

		workingPanel = new CenterPanel(0.8);

		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);
		addListener();
	}

	private void addListener() {
		ManaWorkpanelListener listener = new ManaWorkpanelListener();

		bBusApp.addActionListener(listener);
		bBusLis_all.addActionListener(listener);
		bCusCom.addActionListener(listener);

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance, 1);
	}

}
