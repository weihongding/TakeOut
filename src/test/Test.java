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

		// // ��������ԭ�ļ���·��
		// File file = new File("f:/a/a.xlsx");
		// // ��ԭ�ļ�����Ϊf:\a\b.xlsx������·���Ǳ�Ҫ�ġ�ע��
		// file.renameTo(new File("f:/a/b.xlsx"));
		// // ��������ԭ�ļ��е�·��
		// File file1 = new File("f:/A");
		// // ��ԭ�ļ��и���ΪA������·���Ǳ�Ҫ�ġ�ע��
		// file1.renameTo(new File("f:/B"));

		String name;
		String bus1 = "ŶŶŶ";
		String bus2 = "�ǺǺ�";
		int bl = bus1.length();
		File file = new File("img"); // ��ȡ��file����
		File[] fs = file.listFiles(); // ����path�µ��ļ���Ŀ¼������File������

		for (File f : fs) { // ����File[]����
			if (f.getName().startsWith(bus1)) {
				name = f.getName().replaceAll(bus1, bus2);
				f.renameTo(new File("img/"+name));
			}
		}
	}

}