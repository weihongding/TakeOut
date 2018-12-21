package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Apply;
import service.ApplyService;
import service.BusinessService;
import util.GUIUtil;

public class ApplyFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}

	JLabel[] jl = new JLabel[2];
	JTextArea jta = new JTextArea(10, 30);
	JButton bSub = new JButton("确定");
	Apply app = null;
	JPanel pTitle = new JPanel();
	JPanel pCent = new JPanel();
	JPanel pSout = new JPanel();

	public ApplyFrame(int aid) {
		app = ApplyService.get(aid);

		jl[0] = new JLabel("店家：" + BusinessService.get(app.getBid()).getName(), JLabel.CENTER);
		jl[1] = new JLabel("状态：" + BusinessService.get(app.getBid()).getState(), JLabel.CENTER);
		pTitle.add(jl[0]);
		pTitle.add(jl[1]);
		pTitle.setLayout(new GridLayout(1, 2));
		jta.setLineWrap(true);
		jta.setText(app.getContent());
		jta.setEditable(false);
		pCent.add(jta);
		bSub.addActionListener(this);
		pSout.add(bSub);

		this.setTitle("上架申请");
		this.setLayout(new BorderLayout());
		this.add(pTitle, BorderLayout.NORTH);
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);
	}

	public static void main(String[] args) {
		new ApplyFrame(18).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "确定") {
			dispose();
		}
	}
}
