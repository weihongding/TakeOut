package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

/**
 * �̼�ҳ����ģ��
 * 
 * @���� ��ΰ��
 *
 */
public class BusinessPanel extends JPanel {

	public static BusinessPanel instance = new BusinessPanel();
	public JToolBar tb = new JToolBar();
	public JButton bMenLis = new JButton("�˵�");
	public JButton bOrdLis = new JButton("����");
	public JButton bEarn = new JButton("����");
	public JButton bMy = new JButton("�ҵ�");
	public CenterPanel workingPanel;

	private BusinessPanel() {
		tb.add(bMenLis);
		tb.add(bOrdLis);
		tb.add(bEarn);
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
		bMenLis.addActionListener(listener);
		bOrdLis.addActionListener(listener);
		bEarn.addActionListener(listener);
		bMy.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance, 1);
	}
}
