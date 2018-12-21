package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Complain;
import entity.Complain_dispose;
import gui.model.CusComTableModel;
import gui.panel.M_CusComPanel;
import service.ComplainService;
import service.CustomerService;
import util.GUIUtil;
import util.StateUtil;
import util.TableInstance;

public class ComplainFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}
	public static ComplainFrame instance = new ComplainFrame();
	public JLabel[] jl = new JLabel[2];
	public JTextArea jta1 = new JTextArea(10, 30);
	public JTextArea jta2 = new JTextArea(10, 30);
	public JButton bSub = new JButton("ȷ��");
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JPanel p1 = new JPanel();
	public JPanel p2 = new JPanel();

	public ComplainFrame() {
	}

	public ComplainFrame(int coid) {
		Complain comp = ComplainService.get(coid);
		Complain_dispose comp_dis = ComplainService.get_dis_last(coid);

		jl[0] = new JLabel("�˿ͣ�" + CustomerService.get(comp.getCid()).getName(), JLabel.CENTER);
		jl[1] = new JLabel("����Ա�ظ���", JLabel.CENTER);

		jta1.setLineWrap(true);
		jta1.setText(comp.getContent());
		jta1.setEditable(false);
		p1.add(jl[0]);
		p1.add(jta1);
		p1.setLayout(new GridLayout(2, 1));

		jta2.setLineWrap(true);
		String contect = (comp_dis == null ? "����Ա��δ�ظ������Ժ��ٿ�" : comp_dis.getContent());
		jta2.setText(contect);
		jta2.setEditable(false);
		p2.add(jl[1]);
		p2.add(jta2);
		p2.setLayout(new GridLayout(2, 1));

		pCent.add(p1);
		pCent.add(p2);
		pCent.setLayout(new GridLayout(2, 1));

		bSub.addActionListener(this);
		pSout.add(bSub);

		this.setTitle("�ϼ�����");
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
	}

	public static void main(String[] args) {
		new ComplainFrame(7).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ȷ��") {
			dispose();
		}
		if (e.getActionCommand() == "�ύ") {
			int coid = (Integer) CusComTableModel.instance_m.getValueAt(TableInstance.instance_com_m.getSelectedRow(),
					0);
			Complain_dispose comp_dis = new Complain_dispose(coid, GUIUtil.mana_id, jta2.getText());
			ComplainService.add(comp_dis);
			JOptionPane.showMessageDialog(null, "Ͷ�߽���ظ��ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			dispose();
			M_CusComPanel.instance.updateData();
		}
	}
}
