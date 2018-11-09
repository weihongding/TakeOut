package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Customer;
import gui.listener.ToolBarListener;

/**
 * 个人修改页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_MyModPanel extends WorkingPanel{


	public static B_MyModPanel instance = new B_MyModPanel();
	public Customer c = new Customer(1,"食堂一号", "超好吃", "15959857669", "福大学生街");//后期service直接传入id，返回一个customer对象
	public JButton bSave = new JButton("保存");
	public JLabel[] jl = new JLabel[4];
	public JTextField[] jtf = new JTextField[4];
	public JPanel[] jp = new JPanel[4];
	public JPanel jp_all = new JPanel();
	public JPanel pSubmit = new JPanel();
	
	private B_MyModPanel() {
		
		for (int i = 0;i<4;i++) {
			jl[i] = new JLabel();
			jp[i] = new JPanel();
			jtf[i] = new JTextField(10);
		}
		jl[0].setText("昵称：");
		jl[1].setText("备注：");
		jl[2].setText("电话：");
		jl[3].setText("地址：");
		jtf[0].setText(c.getName());
		jtf[1].setText(c.getDes());
		jtf[2].setText(c.getPhone());
		jtf[3].setText(c.getAddress());
		
		for(int i = 0;i<4;i++){
			jp[i].add(jl[i]);
			jp[i].add(jtf[i]);
		}
		
		for (JPanel jpa : jp) {
			jp_all.add(jpa);
		}
		
		jp_all.setLayout(new GridLayout(4,1));
		
		pSubmit.add(bSave);
		
		this.setLayout(new BorderLayout());
		this.add(jp_all, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		
		addListener();
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		ToolBarListener listener = new ToolBarListener();
		bSave.addActionListener(listener);
	}
}
