package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.jdbc.UpdatableResultSet;

import entity.Food;
import gui.FrameAdd.MenuAddFrame;
import gui.FrameAdd.MenuModFrame;
import gui.model.MenuTableModel;
import gui.panel.B_MenLisPanel;
import service.BusinessService;
import service.FoodService;
import util.CheckUtil;
import util.GUIUtil;

public class MenuListener implements ActionListener {

	static String add_oldname = "img/NotImage";
	static String mod_oldname = "img/NotImage";

	@Override
	public void actionPerformed(ActionEvent e) {

		MenuAddFrame madd = MenuAddFrame.instance;
		MenuModFrame mmod = MenuModFrame.instance;

		JButton b = (JButton) e.getSource();// ��ȡ��ť

		if (b == madd.bSave) {
			if (madd.jtf[0].getText().equals("") || madd.jtf[1].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����/�۸���Ϊ�գ�", "����", JOptionPane.ERROR_MESSAGE);
			} else if (!CheckUtil.isDouble(madd.jtf[1].getText())) {
				JOptionPane.showMessageDialog(null, "�۸�ֻ��Ϊ����", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				String foodname = madd.jtf[0].getText();
				double price = Double.parseDouble(madd.jtf[1].getText());
				String imgname = GUIUtil.get_Foodimgpath(foodname);
				GUIUtil.ImageCopy(add_oldname, imgname);
				Food food = new Food(foodname, price, imgname, GUIUtil.bus_id);// ����һ��Foodʵ����������service
				FoodService.add(food);
				JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				B_MenLisPanel.instance.updateData();
				madd.setVisible(false);
			}
		}
		if (b == madd.bIcon) {
			String foodname = madd.jtf[0].getText();
			add_oldname = GUIUtil.imgcho();
			if (!add_oldname.equals("img/NotImage.jpg"))
				madd.updateDate(add_oldname);
		}
		if (b == mmod.bSave) {
			if (mmod.jtf[0].getText().equals("") || mmod.jtf[1].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����/�۸���Ϊ�գ�", "����", JOptionPane.ERROR_MESSAGE);
			} else if (!CheckUtil.isDouble(mmod.jtf[1].getText())) {
				JOptionPane.showMessageDialog(null, "�۸�ֻ��Ϊ����", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				String foodname = mmod.jtf[0].getText();
				double price = Double.parseDouble(mmod.jtf[1].getText());
				String imgname = GUIUtil.get_Foodimgpath(foodname);// ���Ԥ��ͼƬ��ַ
				if (!mod_oldname.equals("img/NotImage"))// �ж��Ƿ�ѡ�����µ�ͼƬ
					GUIUtil.ImageCopy(mod_oldname, imgname);// ��ѡ��õ���ͼƬ����Ԥ��ͼƬ
				Food food = MenuModFrame.food;
				food.setName(foodname);
				food.setPrice(price);
				food.setImage(imgname);
				FoodService.update(food);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				B_MenLisPanel.instance.updateData();
				mmod.setVisible(false);
			}
		}
		if (b == mmod.bIcon) {
			int i = B_MenLisPanel.instance.t.getSelectedRow();
			String foodname = (String) MenuTableModel.instance1.getValueAt(i, 0);
			mod_oldname = GUIUtil.imgcho();
			if (!mod_oldname.equals("img/NotImage.jpg"))
				mmod.updateDate(mod_oldname);
		}
	}

}
