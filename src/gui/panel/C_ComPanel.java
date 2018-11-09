package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.TableSelectedListener;
import util.TableInstance;

/**
 * 投诉建议
 * 
 * @see 顾客子页面
 * @作者 丁伟宏
 *
 */
public class C_ComPanel extends WorkingPanel{
	public static C_ComPanel instance = new C_ComPanel();
	public JButton bSee = new JButton("查看详情");
	public JButton bAdd = new JButton("新增");
	public JTable t = TableInstance.instance_com_c;
	
	public C_ComPanel() {
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bAdd);

		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}
	
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		TableSelectedListener listener = new TableSelectedListener();
		bSee.addActionListener(listener);
		bAdd.addActionListener(listener);
		
	}

}
