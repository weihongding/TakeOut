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
	public JButton bSub = new JButton("确定");
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JPanel p1 = new JPanel();
	public JPanel p2 = new JPanel();

	public ComplainFrame() {
	}

	public ComplainFrame(int coid) {
		Complain comp = ComplainService.get(coid);
		Complain_dispose comp_dis = ComplainService.get_dis_last(coid);

		jl[0] = new JLabel("顾客：" + CustomerService.get(comp.getCid()).getName(), JLabel.CENTER);
		jl[1] = new JLabel("管理员回复：", JLabel.CENTER);

		jta1.setLineWrap(true);
		jta1.setText(comp.getContent());
		jta1.setEditable(false);
		p1.add(jl[0]);
		p1.add(jta1);
		p1.setLayout(new GridLayout(2, 1));

		jta2.setLineWrap(true);
		String contect = (comp_dis == null ? "管理员暂未回复，请稍后再看" : comp_dis.getContent());
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

		this.setTitle("上架申请");
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
		if (e.getActionCommand() == "确定") {
			dispose();
		}
		if (e.getActionCommand() == "提交") {
			int coid = (Integer) CusComTableModel.instance_m.getValueAt(TableInstance.instance_com_m.getSelectedRow(),
					0);
			Complain_dispose comp_dis = new Complain_dispose(coid, GUIUtil.mana_id, jta2.getText());
			ComplainService.add(comp_dis);
			JOptionPane.showMessageDialog(null, "投诉建议回复成功！", "提示", JOptionPane.PLAIN_MESSAGE);
			dispose();
			M_CusComPanel.instance.updateData();
		}
	}
}
