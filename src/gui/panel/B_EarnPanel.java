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
	public JButton bTmonth = new JButton("本周"); 
	public JButton bTime = new JButton("选择时间段");
	
	private B_EarnPanel() {
		JLabel l = new JLabel();
		Image img = ChartUtil.getImage(350, 250);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		
		JScrollPane sp = new JScrollPane(l);
		JPanel pSubmit = new JPanel();
		
		pSubmit.add(bTmonth);
		pSubmit.add(bTime);
		
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
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
		// TODO Auto-generated method stub

	}

}
