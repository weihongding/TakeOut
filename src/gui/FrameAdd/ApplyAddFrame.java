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
	JButton bSub = new JButton("提交");
	JButton bCan = new JButton("取消");
	JPanel pCent = new JPanel();
	JPanel pSout = new JPanel();

	public ApplyAddFrame() {
		jta.setLineWrap(true);
		jta.setText("请简要说明");
		pCent.add(jta);
		bSub.addActionListener(this);
		bCan.addActionListener(this);
		pSout.add(bSub);
		pSout.add(bCan);

		this.setTitle("上架申请");
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
		if (e.getActionCommand() == "提交") {
			int bid = GUIUtil.bus_id;
			String content = jta.getText();
			Apply app = new Apply(bid, content);
			ApplyService.add(app);
			JOptionPane.showMessageDialog(null, "提交成功！" , "提示", JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
		if (e.getActionCommand() == "取消") {
			dispose();
		}
	}

}
