package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import gui.model.MenuTableModel;
import gui.model.OrderCarTableModel;

/**
 * GUI������
 * 
 * @���� ��ΰ��
 *
 */
public class GUIUtil {
	public static int cus_id = 9;
	public static int bus_id = 5;
	public static int mana_id = 1;

	/**
	 * ��ʾPanel
	 * 
	 * @param p
	 * @param strechRate
	 *            �������1��ʾ����Ļ
	 */
	public static void showPanel(JPanel p, double strechRate) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	/**
	 * 0.85�ı�����ʾPanel
	 * 
	 * @param p
	 */
	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

	/**
	 * ��������Ƿ�Ϊ����
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}

	/**
	 * ��������Ƿ�Ϊ0
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText().trim();

		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	/**
	 * ��������Ƿ�Ϊ��
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;

	}

	/**
	 * ��������ı�ת��Ϊint
	 * 
	 * @param tf
	 * @return
	 */
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}

	/**
	 * ����ͼƬ��С
	 * 
	 * @param width
	 * @param hight
	 * @return
	 */
	public static ImageIcon setimgwh(String iconpath, int width, int hight) {
		ImageIcon icon = new ImageIcon(iconpath);
		icon.setImage(icon.getImage().getScaledInstance(width, hight, Image.SCALE_DEFAULT));
		return icon;
	}

	/**
	 * �õ�һ������1
	 * 
	 * @param ���鳤��
	 * @return
	 */
	public static int[] getArray_int_num(int num) {
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = 0;
		}
		return array;
	}

	/**
	 * �õ�һ������2
	 * 
	 * @param ���
	 * @param ������������
	 * @return
	 */
	public static int[] getArray_int_table(AbstractTableModel t, int num) {
		int count = t.getRowCount();
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = Integer.parseInt((String) t.getValueAt(i, num));
		}
		return array;
	}

	/**
	 * �õ������з�0���ֵ��±�����
	 * 
	 * @param ԭ����
	 * @return �±�����
	 */
	public static ArrayList<Integer> getArray_int_index(int[] num) {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0)
				array.add(i);
		}
		return array;
	}

	/**
	 * ��������ͱ�õ�ȥ�������Ӧ�ı�
	 * 
	 * @param ԭ��
	 * @param ����
	 * @return ȥ�������Ӧ�ı�
	 */
	public static String[][] getArray_String(AbstractTableModel t, int[] num) {

		ArrayList<Integer> array = getArray_int_index(num);
		String[][] str = new String[array.size()][3];
		for (int i = 0; i < array.size(); i++) {
			str[i][0] = (String) t.getValueAt(i, 0);
			str[i][1] = Double.toString((Double) t.getValueAt(i, 1));
			str[i][2] = Integer.toString(num[array.get(i)]);
		}
		return str;
	}

	/**
	 * �������е��ܺ�
	 * 
	 * @param ���
	 * @param a��
	 * @param b��
	 * @return a��*b�к�ĳ˻���
	 */
	public static double getSum(AbstractTableModel t, int a, int b) {
		double sum = 0;
		for (int i = 0; i < t.getRowCount(); i++) {
			sum += (Double.parseDouble((String) t.getValueAt(i, a)) * Integer.parseInt((String) t.getValueAt(i, b)));
		}
		return sum;
	}

	public static void main(String[] args) {

	}

}