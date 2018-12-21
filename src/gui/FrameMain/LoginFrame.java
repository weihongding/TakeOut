package gui.FrameMain;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import gui.panel.BusinessPanel;
import gui.panel.CustomerPanel;
import gui.panel.ManagePanel;
import service.BusinessService;
import service.CustomerService;
import service.ManagerService;
import util.GUIUtil;

/**
 * �û���¼ҳ��
 * 
 * @���� ��ΰ��
 *
 */
public class LoginFrame extends JFrame implements ActionListener {
	static {
		GUIUtil.useLNF();
	}
	public static LoginFrame instance = new LoginFrame();
	JPanel jp1, jp2, jp3, jp4, jp5, jp6;
	JButton jb1, jb2, jb3;
	JLabel jl1, jl2, jl3, jl4, jl5;
	JTextField jtf;
	JPasswordField jpf;
	JRadioButton jrb1, jrb2, jrb3;
	ButtonGroup bg;

	private LoginFrame() {

		GridBagLayout gridbag = new GridBagLayout();// ���������
		GridBagConstraints c = null;// Լ��

		this.setLayout(gridbag);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();

		jb1 = new JButton("��½");
		jb2 = new JButton("����");
		jb3 = new JButton("ע��");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);

		jl1 = new JLabel("�� �ţ�");
		jl2 = new JLabel("�� �룺");
		jl3 = new JLabel("Ȩ �ޣ�");
		jtf = new JTextField(10);
		jpf = new JPasswordField(18);

		jrb1 = new JRadioButton("�˿�");
		jrb2 = new JRadioButton("�̼�");
		jrb3 = new JRadioButton("����Ա");
		jrb1.setSelected(true);
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);

		jp1.add(jl1);
		jp1.add(jtf);
		jp2.add(jl2);
		jp2.add(jpf);
		jp3.add(jl3);
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp5.add(jrb3);
		jp6.add(jb1);
		jp6.add(jb2);
		jp6.add(jb3);

		// �˺ż������������һ��
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp1, c);

		// ���뼰����������ڶ���
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp2, c);

		// Ȩ������ռ����
		c = new GridBagConstraints();
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp3, c);

		// Ȩ��ѡ������
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp4, c);
		gridbag.addLayoutComponent(jp5, c);

		// ��ť�������һ��
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp6, c);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);

		this.setTitle("��¼����");
		this.setSize(300, 250);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setVisible(true);
		this.setResizable(false);
		this.setResizable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "��½") {
			if (jrb1.isSelected()) {
				// ��֤�˿��˺�����
				// ���ؽ��
				int id = CustomerService.check(jtf.getText(), jpf.getText());
				if (id != -1) {
					GUIUtil.cus_id = id;
					dispose();
					CustomerFrame.instance.show();
					CustomerPanel.instance.workingPanel.show(new JLabel("��ӭʹ�ù˿�ҳ�棡"));
				}
			} else if (jrb2.isSelected()) {
				// ��֤�̼��ʺ�����
				// ���ؽ��
				int id = BusinessService.check(jtf.getText(), jpf.getText());
				if (id != -1) {
					GUIUtil.bus_id = id;
					dispose();
					BusinessFrame.instance.show();
					BusinessPanel.instance.workingPanel.show(new JLabel("��ӭʹ���̼�ҳ�棡"));
				}
			} else if (jrb3.isSelected()) {
				// ��֤����Ա�ʺ�����
				// ���ؽ��
				int id = ManagerService.check(jtf.getText(), jpf.getText());
				if (id != -1) {
					GUIUtil.mana_id = id;
					dispose();
					ManageFrame.instance.show();
					ManagePanel.instance.workingPanel.show(new JLabel("��ӭʹ�ù���Աҳ�棡"));
				}
			}
		} else if (e.getActionCommand() == "����") {
			clean();
		} else if (e.getActionCommand() == "ע��") {
			dispose();
			RegisterFrame.instance.setVisible(true);
		}

	}

	public static void main(String[] args) {
		LoginFrame.instance.show();
	}

	private void clean() {
		jtf.setText("");
		jpf.setText("");
	}

}
