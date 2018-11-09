package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import gui.listener.ToolBarListener;
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
	public JButton bBusLis_up = new JButton("上架中商家");
	public JButton bBusLis_down = new JButton("下架中商家");
	public JButton bCusCom = new JButton("投诉建议");
	public CenterPanel workingPanel;

	private ManagePanel() {
		tb.add(bBusApp);
		tb.add(bBusLis_up);
		tb.add(bBusLis_down);
		tb.add(bCusCom);
		tb.setFloatable(false);

		workingPanel = new CenterPanel(0.8);
		
		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);
		addListener();
	}

	private void addListener() {
		ToolBarListener listener = new ToolBarListener();

		bBusApp.addActionListener(listener);
		bBusLis_up.addActionListener(listener);
		bBusLis_down.addActionListener(listener);
		bCusCom.addActionListener(listener);

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance, 1);
	}

}
