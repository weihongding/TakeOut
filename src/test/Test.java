package test;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;
import util.GUIUtil;

public class Test {

	public static void main(String[] args) {

		// // 想命名的原文件的路径
		// File file = new File("f:/a/a.xlsx");
		// // 将原文件更改为f:\a\b.xlsx，其中路径是必要的。注意
		// file.renameTo(new File("f:/a/b.xlsx"));
		// // 想命名的原文件夹的路径
		// File file1 = new File("f:/A");
		// // 将原文件夹更改为A，其中路径是必要的。注意
		// file1.renameTo(new File("f:/B"));

		String name;
		String bus1 = "哦哦哦";
		String bus2 = "呵呵呵";
		int bl = bus1.length();
		File file = new File("img"); // 获取其file对象
		File[] fs = file.listFiles(); // 遍历path下的文件和目录，放在File数组中

		for (File f : fs) { // 遍历File[]数组
			if (f.getName().startsWith(bus1)) {
				name = f.getName().replaceAll(bus1, bus2);
				f.renameTo(new File("img/"+name));
			}
		}
	}

}