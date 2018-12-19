package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.Apply;
import service.ApplyService;
import util.GUIUtil;

public class ApplyAddFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}
	JTextArea jta = new JTextArea(10, 20);
	JButton bSub = new JButton("�ύ");
	JButton bCan = new JButton("ȡ��");
	JPanel pCent = new JPanel();
	JPanel pSout = new JPanel();

	public ApplyAddFrame() {
		jta.setLineWrap(true);
		jta.setText("���Ҫ˵��");
		pCent.add(jta);
		bSub.addActionListener(this);
		bCan.addActionListener(this);
		pSout.add(bSub);
		pSout.add(bCan);

		this.setTitle("�ϼ�����");
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
	}

	public static void main(String[] args) {
		new ApplyAddFrame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "�ύ") {
			int bid = GUIUtil.bus_id;
			String content = jta.getText();
			Apply app = new Apply(bid, content);
			ApplyService.add(app);
			JOptionPane.showMessageDialog(null, "�ύ�ɹ���" , "��ʾ", JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
		if (e.getActionCommand() == "ȡ��") {
			dispose();
		}
	}

}
