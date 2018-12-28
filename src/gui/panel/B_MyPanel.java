package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Business;
import gui.listener.BusWorkpanelListener;
import service.ApplyService;
import service.BusinessService;
import util.GUIUtil;

/**
 * 个人页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_MyPanel extends WorkingPanel {
	public static B_MyPanel instance = new B_MyPanel();
	public Business b = BusinessService.get(GUIUtil.bus_id);
	public JButton bMod = new JButton("修改");
	public JButton bApp = new JButton("申请上架");
	public JLabel[] jl = new JLabel[10];
	public JPanel[] jp = new JPanel[5];
	public JPanel jp_all = new JPanel();
	public JPanel pSubmit = new JPanel();

	private B_MyPanel() {
		for (int i = 0; i < 10; i++) {
			jl[i] = new JLabel();
		}
		for (int i = 0; i < 5; i++) {
			jp[i] = new JPanel();
		}
		jl[0].setText("昵称：");
		jl[1].setText("备注：");
		jl[2].setText("电话：");
		jl[3].setText("地址：");
		jl[4].setText("状态：");
		jl[5].setText(b.getName());
		jl[6].setText(b.getDes());
		jl[7].setText(b.getPhone());
		jl[8].setText(b.getAddress());
		jl[9].setText(b.getState()+"("+ApplyService.getstate(b.getId())+")");

		for (int i = 0; i < 5; i++) {
			jp[i].add(jl[i]);
			jp[i].add(jl[i + 5]);
		}

		for (JPanel jpa : jp) {
			jp_all.add(jpa);
		}

		jp_all.setLayout(new GridLayout(5, 1));

		pSubmit.add(bMod);
		pSubmit.add(bApp);

		this.setLayout(new BorderLayout());
		this.add(jp_all, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance);
	}

	@Override
	public void updateData() {
		b = BusinessService.get(GUIUtil.bus_id);
		jl[5].setText(b.getName());
		jl[6].setText(b.getDes());
		jl[7].setText(b.getPhone());
		jl[8].setText(b.getAddress());
		jl[9].setText(b.getState()+"("+ApplyService.getstate(b.getId())+")");
	}

	@Override
	public void addListener() {
		BusWorkpanelListener listener = new BusWorkpanelListener();
		bMod.addActionListener(listener);
		bApp.addActionListener(listener);
	}

}
