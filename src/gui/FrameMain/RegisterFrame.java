package gui.FrameMain;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import gui.panel.BusinessPanel;
import gui.panel.CustomerPanel;
import service.CustomerService;
import util.CheckUtil;

public class RegisterFrame extends JFrame implements ActionListener {

	public static RegisterFrame instance = new RegisterFrame();
	JLabel jl1, jl2, jl3, jl4;
	JTextField jtf;
	JPasswordField jpf1, jpf2;
	JRadioButton jrb1, jrb2;
	ButtonGroup bg;
	JPanel jp1, jp2, jp3, jp4, jp5;
	JButton jb1, jb2, jb3;

	private RegisterFrame() {

		GridBagLayout gridbag = new GridBagLayout();// ���������
		GridBagConstraints c = null;// Լ��

		this.setLayout(gridbag);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();

		jb1 = new JButton("ע��");
		jb2 = new JButton("����");
		jb3 = new JButton("�˳�");
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jl1 = new JLabel("ע �� �� �ţ�");
		jl2 = new JLabel("ע �� �� �룺");
		jl3 = new JLabel("�ٴ��������룺");
		jl4 = new JLabel("Ȩ �ޣ�");
		jtf = new JTextField(10);
		jpf1 = new JPasswordField(10);
		jpf2 = new JPasswordField(10);

		jrb1 = new JRadioButton("�˿�");
		jrb2 = new JRadioButton("�̼�");
		jrb1.setSelected(true);
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		jp1.add(jl1);
		jp1.add(jtf);
		jp2.add(jl2);
		jp2.add(jpf1);
		jp3.add(jl3);
		jp3.add(jpf2);
		jp4.add(jl4);
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp5.add(jb1);
		jp5.add(jb2);
		jp5.add(jb3);

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

		// �������뼰����������ڶ���
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp3, c);

		// Ȩ�޼�ѡ������������
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp4, c);

		// ��ť�������һ��
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp5, c);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);

		this.setTitle("ע�����");
		this.setSize(300, 250);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setVisible(true);
		this.setResizable(false);
		this.setResizable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ע��") {
			if (jrb1.isSelected()) {
				if(jtf.getText().equals("")){
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "ע����Ϣ ",JOptionPane.ERROR_MESSAGE);
				}else if(jpf1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "ע����Ϣ ",JOptionPane.ERROR_MESSAGE);
				}else if(!(jpf1.getText().equals(jpf2.getText()))){
					JOptionPane.showMessageDialog(null, "�������벻һ�£�", "ע����Ϣ ",JOptionPane.ERROR_MESSAGE);
				}else if(CheckUtil.Password_Register(jpf1.getText())){
					new CustomerService().add((String)jtf.getText(), (String)jpf1.getText());
					JOptionPane.showMessageDialog(null, "ע��ɹ���", "ע����Ϣ",JOptionPane.PLAIN_MESSAGE); 
				}
			} else if (jrb2.isSelected()) {

			}
		} else if (e.getActionCommand() == "����") {
			clean();
		} else if (e.getActionCommand() == "�˳�") {
			dispose();
		}

	}

	public static void main(String[] args) {
		instance.show();
	}

	private void clean() {
		jtf.setText("");
		jpf1.setText("");
		jpf2.setText("");
	}

}
