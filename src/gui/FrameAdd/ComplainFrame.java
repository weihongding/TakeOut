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

import entity.Complain;
import entity.Complain_dispose;
import service.ComplainService;
import service.CustomerService;
import util.GUIUtil;

public class ComplainFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}

	JLabel[] jl = new JLabel[2];
	JTextArea jta1 = new JTextArea(10, 30);
	JTextArea jta2 = new JTextArea(10, 30);
	JButton bSub = new JButton("确定");
	Complain comp = null;
	Complain_dispose comp_dis = null;
	JPanel pTitle = new JPanel();
	JPanel pCent = new JPanel();
	JPanel pSout = new JPanel();
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();

	public ComplainFrame(int coid) {
		comp = ComplainService.get(coid);
		comp_dis = ComplainService.get_dis_last(coid);

		jl[0] = new JLabel("店家：" + CustomerService.get(comp.getCid()).getName(), JLabel.CENTER);
		jl[1] = new JLabel("状态：" + comp.getState(), JLabel.CENTER);
		pTitle.add(jl[0]);
		pTitle.add(jl[1]);
		pTitle.setLayout(new GridLayout(1, 2));
		jta1.setLineWrap(true);
		jta1.setText(comp.getContent());
		jta1.setEditable(false);
		pCent.add(jta1);
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
		new ComplainFrame(18).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "确定") {
			dispose();
		}
	}
}
