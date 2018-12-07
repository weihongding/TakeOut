package gui.FrameAdd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Food;
import gui.listener.FrameAddListener;
import gui.listener.MenuListener;
import util.GUIUtil;

/**
 * 修改菜品信息
 * 
 * @作者 丁伟宏
 *
 */
public class MenuModFrame extends JFrame {

	public static MenuModFrame instance = new MenuModFrame(new Food("无", 10, "img/NotImage.jpg", 5));
	public static Food food = null;
	public JLabel[] jl = new JLabel[2];
	public JPanel[] jp = new JPanel[3];
	public JLabel jicon = new JLabel();
	public JPanel pCent = new JPanel();
	public JPanel pSout = new JPanel();
	public JTextField[] jtf = new JTextField[2];
	public JButton bIcon = new JButton("选择新图片");
	public JButton bSave = new JButton("保存");
	public ImageIcon icon;

	public MenuModFrame(Food food) {
		
		this.food = food;
		jl[0] = new JLabel("菜名：");
		jl[1] = new JLabel("价格：");
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
		}

		jtf[0] = new JTextField(10);
		jtf[0].setText(food.getName());
		jtf[1] = new JTextField(10);
		jtf[1].setText(Double.toString(food.getPrice()));
		icon = GUIUtil.setimgwh(food.getImage(), 150, 150);
		jicon.setIcon(icon);

		jp[0].add(jl[0]);
		jp[0].add(jtf[0]);
		jp[0].setLayout(new GridLayout(1, 2));
		jp[1].add(jl[1]);
		jp[1].add(jtf[1]);
		jp[1].setLayout(new GridLayout(1, 2));
		jp[2].add(jicon);
		jp[2].add(bIcon);

		for (int i = 0; i < 3; i++) {
			pCent.add(jp[i]);
		}
		pSout.add(bSave);
		this.setLayout(new BorderLayout());
		this.add(pCent, BorderLayout.CENTER);
		this.add(pSout, BorderLayout.SOUTH);
		this.setSize(350, 300);
		this.setLocation(800, 400);

		addListener();

	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}
	
	public void updateDate(String imgpath){
		icon = GUIUtil.setimgwh(imgpath, 150, 150);
		jicon.setIcon(icon);
	}
	
	public void addListener() {
		MenuListener listener = new MenuListener();
		bSave.addActionListener(listener);
		bIcon.addActionListener(listener);
	}

}
