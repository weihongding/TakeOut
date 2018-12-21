package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Complain;
import gui.panel.C_ComPanel;
import service.ComplainService;
import util.GUIUtil;

public class ComplainAddFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}
	JTextArea jta = new JTextArea(10, 20);
	JButton bSub = new JButton("�ύ");
	JButton bCan = new JButton("ȡ��");
	JPanel pCent = new JPanel();
	JPanel pSout = new JPanel();

	public ComplainAddFrame() {
		jta.setLineWrap(true);
		jta.setText("���Ҫ˵��");
		pCent.add(jta);
		bSub.addActionListener(this);
		bCan.addActionListener(this);
		pSout.add(bSub);
		pSout.add(bCan);

		this.setTitle("Ͷ�߽���");
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
	}

	public static void main(String[] args) {
		new ComplainAddFrame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "�ύ") {
			int cid = GUIUtil.cus_id;
			String content = jta.getText();
			Complain app = new Complain(cid, content);
			ComplainService.add(app);
			JOptionPane.showMessageDialog(null, "�ύ�ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			dispose();
			C_ComPanel.instance.updateData();
		}
		if (e.getActionCommand() == "ȡ��") {
			dispose();
		}
	}
}
