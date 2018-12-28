package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.BusTableListener;
import gui.model.MenuTableModel;
import service.FoodService;
import util.GUIUtil;

/**
 * 菜单页面
 * 
 * @see 商户子页面
 * @作者 丁伟宏
 *
 */
public class B_MenLisPanel extends WorkingPanel {

	public static B_MenLisPanel instance = new B_MenLisPanel();
	public JButton bSign = new JButton("明星菜品");
	public JButton bAdd = new JButton("新增");
	public JButton bMod = new JButton("修改");
	public JButton bDel = new JButton("删除");
	public JTable t;
	public JScrollPane sp;

	private B_MenLisPanel() {
		t = new JTable(MenuTableModel.instance1);
		sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSign);
		pSubmit.add(bAdd);
		pSubmit.add(bMod);
		pSubmit.add(bDel);

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
		MenuTableModel.instance1 = new MenuTableModel(FoodService.list_b(GUIUtil.bus_id));
		t.setModel(MenuTableModel.instance1);
		sp.setViewportView(t);
	}

	@Override
	public void addListener() {
		BusTableListener listener = new BusTableListener();
		bSign.addActionListener(listener);
		bAdd.addActionListener(listener);
		bMod.addActionListener(listener);
		bDel.addActionListener(listener);
	}

}
