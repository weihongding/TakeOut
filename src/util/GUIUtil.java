package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import service.BusinessService;

/**
 * GUI工具类
 * 
 * @作者 丁伟宏
 *
 */
public class GUIUtil {
	public static int cus_id = 9;
	public static int bus_id = 5;
	public static int mana_id = 1;
	public static int c_bid = 5;

	public static void main(String[] args) {

	}
	
    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	/**
	 * 显示Panel
	 * 
	 * @param p
	 * @param strechRate
	 *            拉伸比例1表示满屏幕
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
	 * 0.85的比例显示Panel
	 * 
	 * @param p
	 */
	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

	/**
	 * 检查数字是否为整数
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
			JOptionPane.showMessageDialog(null, input + " 需要是整数");
			tf.grabFocus();
			return false;
		}
	}

	/**
	 * 检查数字是否为0
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
			JOptionPane.showMessageDialog(null, input + " 不能为零");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	/**
	 * 检查输入是否为空
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + " 不能为空");
			tf.grabFocus();
			return false;
		}
		return true;

	}

	/**
	 * 将输入的文本转化为int
	 * 
	 * @param tf
	 * @return
	 */
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}

	/**
	 * 设置图片大小
	 * 
	 * @param width
	 * @param hight
	 * @return
	 */
	public static ImageIcon setimgwh(String iconPath, int width, int hight) {
		ImageIcon icon = new ImageIcon(iconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, hight, Image.SCALE_DEFAULT));
		return icon;
	}

	/**
	 * 得到一个数组1
	 * 
	 * @param 数组长度
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
	 * 得到一个数组2
	 * 
	 * @param 表格
	 * @param 数字所在列数
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
	 * 得到数组中非0数字的下标数组
	 * 
	 * @param 原数组
	 * @return 下标数组
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
	 * 根据数组和表得到去零数组对应的表
	 * 
	 * @param 原表
	 * @param 数组
	 * @return 去零数组对应的表
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
	 * 计算表格中的总和
	 * 
	 * @param 表格
	 * @param a列
	 * @param b列
	 * @return a列*b列后的乘积和
	 */
	public static double getSum(AbstractTableModel t, int a, int b) {
		double sum = 0;
		for (int i = 0; i < t.getRowCount(); i++) {
			sum += (Double.parseDouble((String) t.getValueAt(i, a)) * Integer.parseInt((String) t.getValueAt(i, b)));
		}
		return sum;
	}

	/**
	 * 根据菜名和登陆的商家id得到预留的图片地址
	 * 
	 * @param foodname
	 * @return
	 */
	public static String get_Foodimgpath(String foodname) {
		String filePath = "img/" + BusinessService.get(bus_id).getName() + "-" + foodname + ".jpg";
		return filePath;
	}

	/**
	 * 图片复制器
	 * 
	 * @param oldpath
	 * @param newpath
	 */
	public static void ImageCopy(String oldpath, String newpath) {
		File file = new File(oldpath);
		copyFile(file, newpath);
	}

	/**
	 * 图片选择器
	 * 
	 * @param foodname
	 * @return 选择的实际图片的地址
	 */
	public static String imgcho() {
		ImageChoose ic = new ImageChoose();
		File file = ic.getImage();
		if (file == null) {
			JOptionPane.showMessageDialog(null, "未选择图片", "错误", JOptionPane.ERROR_MESSAGE);
			return "img/NotImage.jpg";
		}
		return file.getPath();
	}

	/**
	 * 使用缓存流进行文件复制
	 * 
	 * @param file
	 */
	public static void copyFile(File file, String filePath) {

		File file2 = new File(filePath);

		InputStream inStream = null;
		BufferedInputStream bin = null;
		OutputStream outputStream = null;
		BufferedOutputStream bout = null;
		int i = -1;

		try {
			inStream = new FileInputStream(file);
			bin = new BufferedInputStream(inStream);
			outputStream = new FileOutputStream(filePath);
			bout = new BufferedOutputStream(outputStream);
			while ((i = bin.read()) != -1) {
				bout.write(i);
				// 注意，读取一个字节，然后写入缓存中！需要在最后将缓存中的内容写入文件中！
				// 需要清空缓存区，将缓存区内容写入文件中！-flush()
			}
			// 如果要剪切，在此加一句delete即可！
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// bout.flush();
				bout.close();// close()方法内部自动调用flush()
				outputStream.close();
				bin.close();
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据商家id和菜品名获得菜品绝对路径
	 * 
	 * @param bid
	 * @param foodname
	 * @return
	 */
	public static String getImgPath(int bid, String foodname) {
		String filePath = "img/" + BusinessService.get(bid).getName() + "-" + foodname + ".jpg";
		if (new File(filePath).exists()) {
			return filePath;
		}
		return "img/NotImage.jpg";
	}

}