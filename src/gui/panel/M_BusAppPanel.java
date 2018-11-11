package gui.panel;

import java.awt.BorderLayout;
import java.util.Locale.Category;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import gui.listener.ManaTableListener;
import gui.model.BusLisTableModel;
import util.GUIUtil;
import util.TableInstance;

/**
 * �ϼ�����
 * 
 * @see ����Ա��ҳ��
 * @���� ��ΰ��
 *
 */
public class M_BusAppPanel extends WorkingPanel {
	public static M_BusAppPanel instance = new M_BusAppPanel();

	public JButton bSee = new JButton("�鿴");
	public JButton bAdopt = new JButton("ͨ��");
	public JButton bReject = new JButton("����");
	public JTable t = TableInstance.instance_bus_app;

	private M_BusAppPanel() {
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bAdopt);
		pSubmit.add(bReject);
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

	}

	@Override
	public void addListener() {
		ManaTableListener listener = new ManaTableListener();
		bSee.addActionListener(listener);
		bAdopt.addActionListener(listener);
		bReject.addActionListener(listener);
	}

}
