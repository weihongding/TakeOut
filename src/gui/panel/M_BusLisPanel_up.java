package gui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.listener.ManaTableListener;
import gui.model.BusLisTableModel;
import util.GUIUtil;
import util.TableInstance;

/**
 * �ϼ��е��̼�
 * 
 * @see ����Ա��ҳ��
 * @���� ��ΰ��
 *
 */
public class M_BusLisPanel_up extends WorkingPanel {
	public static M_BusLisPanel_up instance = new M_BusLisPanel_up();

	public JButton bSee = new JButton("�鿴");
	public JButton bDown = new JButton("�¼�");
	public JTable t = TableInstance.instance_bus_up;

	private M_BusLisPanel_up() {
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bDown);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener() {
		ManaTableListener listener = new ManaTableListener();
		bSee.addActionListener(listener);
		bDown.addActionListener(listener);
	}

}
