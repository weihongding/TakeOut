package gui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.listener.TableSelectedListener;
import gui.model.BusLisTableModel;
import util.GUIUtil;
import util.TableInstance;

/**
 * �¼��е��̼�
 * 
 * @see ����Ա��ҳ��
 * @���� ��ΰ��
 *
 */
public class M_BusLisPanel_down extends WorkingPanel {
	public static M_BusLisPanel_down instance = new M_BusLisPanel_down();

	public JButton bSee = new JButton("�鿴");
	public JButton bUp = new JButton("�ϼ�");
	public JTable t = TableInstance.instance_bus_down;

	private M_BusLisPanel_down() {
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bSee);
		pSubmit.add(bUp);
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
		TableSelectedListener listener = new TableSelectedListener();
		bSee.addActionListener(listener);
		bUp.addActionListener(listener);
	}

}
