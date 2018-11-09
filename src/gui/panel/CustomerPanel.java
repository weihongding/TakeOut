package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

/**
 * 顾客页面主模版
 * 
 * @作者 丁伟宏
 *
 */
public class CustomerPanel extends JPanel{

	public static CustomerPanel instance = new CustomerPanel();
	public JToolBar tb = new JToolBar();
	public JButton bBusLis = new JButton("商家");
	public JButton bOrdLis = new JButton("订单");
	public JButton bComplain = new JButton("投诉建议");
	public JButton bMy = new JButton("我的");
	
	public CenterPanel workingPanel;
	
	private CustomerPanel(){
		
		tb.add(bBusLis);
		tb.add(bOrdLis);
		tb.add(bComplain);
		tb.add(bMy);
		tb.setFloatable(false);
		
		workingPanel = new CenterPanel(0.8);
		
		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);

		addListener();
		
	}

	private void addListener() {
		
		ToolBarListener listener = new ToolBarListener();
		
		bBusLis.addActionListener(listener);
		bOrdLis.addActionListener(listener);
		bComplain.addActionListener(listener);
		bMy.addActionListener(listener);
		
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(instance, 1);
	}
	
	
}
