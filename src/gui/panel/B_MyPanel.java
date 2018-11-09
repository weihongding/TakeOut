package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Business;
import gui.listener.ToolBarListener;

/**
 * 个人页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_MyPanel extends WorkingPanel{
	public static B_MyPanel instance = new B_MyPanel();
	public Business c = new Business(1,"食堂一号", "超好吃", "15959857669", "福大学生街","上架中");//后期service直接传入id，返回一个customer对象
	public JButton bMod = new JButton("修改");
	public JLabel[] jl = new JLabel[8];
	public JPanel[] jp = new JPanel[4];
	public JPanel jp_all = new JPanel();
	public JPanel pSubmit = new JPanel();
	
	private B_MyPanel() {
		for (int i = 0;i<8;i++) {
			jl[i] = new JLabel();
		}
		for (int i = 0;i<4;i++) {
			jp[i] = new JPanel();
		}
		jl[0].setText("昵称：");
		jl[1].setText("备注：");
		jl[2].setText("电话：");
		jl[3].setText("地址：");
		jl[4].setText(c.getName());
		jl[5].setText(c.getDes());
		jl[6].setText(c.getPhone());
		jl[7].setText(c.getAddress());
		
		for(int i = 0;i<4;i++){
			jp[i].add(jl[i]);
			jp[i].add(jl[i+4]);
		}
		
		for (JPanel jpa : jp) {
			jp_all.add(jpa);
		}
		
		jp_all.setLayout(new GridLayout(4,1));
		
		pSubmit.add(bMod);
		
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
		bMod.addActionListener(listener);
	}

	
	
}
