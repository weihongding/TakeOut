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
import util.GUIUtil;

/**
 * 用户登录页面
 * 
 * @作者 丁伟宏
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

		GridBagLayout gridbag = new GridBagLayout();// 网格袋布局
		GridBagConstraints c = null;// 约束

		this.setLayout(gridbag);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();

		jb1 = new JButton("登陆");
		jb2 = new JButton("重置");
		jb3 = new JButton("注册");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);

		jl1 = new JLabel("账 号：");
		jl2 = new JLabel("密 码：");
		jl3 = new JLabel("权 限：");
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);

		jrb1 = new JRadioButton("顾客");
		jrb2 = new JRadioButton("商家");
		jrb3 = new JRadioButton("管理员");
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

		// 账号及输入框填满第一行
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp1, c);

		// 密码及输入框填满第二行
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp2, c);

		// 权限在左，占两行
		c = new GridBagConstraints();
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp3, c);

		// 权限选项在右
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridbag.addLayoutComponent(jp4, c);
		gridbag.addLayoutComponent(jp5, c);

		// 按钮填满最后一行
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

		this.setTitle("登录界面");
		this.setSize(300, 250);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置当关闭窗口时，保证JVM也退出
		this.setVisible(true);
		this.setResizable(false);
		this.setResizable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "登陆") {
			if (jrb1.isSelected()) {
				// 验证顾客账号密码
				// 返回结果
				int id = CustomerService.check(jtf.getText(), jpf.getText());
				if (id != -1) {
					GUIUtil.cus_id = id;
					dispose();
					CustomerFrame.instance.show();
					CustomerPanel.instance.workingPanel.show(new JLabel("欢迎使用顾客页面！"));
				}
			} else if (jrb2.isSelected()) {
				// 验证商家帐号密码
				// 返回结果
				int id = BusinessService.check(jtf.getText(), jpf.getText());
				if (id != -1) {
					GUIUtil.bus_id = id;
					dispose();
					BusinessFrame.instance.show();
					BusinessPanel.instance.workingPanel.show(new JLabel("欢迎使用商家页面！"));
				}
			} else if (jrb3.isSelected()) {
				// 验证管理员帐号密码
				// 返回结果
				dispose();
				ManageFrame.instance.show();
				ManagePanel.instance.workingPanel.show(new JLabel("欢迎使用管理员页面！"));
			}
		} else if (e.getActionCommand() == "重置") {
			clean();
		} else if (e.getActionCommand() == "注册") {
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
