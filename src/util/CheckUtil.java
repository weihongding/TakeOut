package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Customer;

public class CheckUtil {

	/**
	 * ����ֻ����Ƿ���ϸ�ʽ
	 */
	public static boolean phoneCheck(String phone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		if (phone.length() != 11) {
			return false;
		} else {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone);
			return m.matches();
		}
	}

	public static boolean Password_Register(String password) {
		return true;
	}

	/**
	 * ĳ�����ĳһ����ĳ�����ݵĸ���
	 * 
	 * @param tablename
	 * @param columnname
	 * @param value
	 * @return count
	 */
	public static int existence_String(String tablename, String columnname, String value) {

		int count = 0;

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from " + tablename + " where " + columnname + " = '" + value + "'";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next())
				count++;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;
	}

	/**
	 * �Ƿ�ֻ��������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * �Ƿ��ڷ�Χ��
	 * 
	 * @param min
	 * @param max
	 * @param value
	 * @return
	 */
	public static boolean inRange(double min, double max, double value) {
		if (value > min && value <= max)
			return true;
		return false;
	}
	
	public static boolean inRange(int min, int max, int value) {
		if (value > min && value <= max)
			return true;
		return false;
	}

	public static int sizeof(String str) {
		return str.length();
	}

	public static boolean isDouble(String str) {
		String reg = "^[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

	public static void main(String[] args) {
		System.out.println(inRange(0, 1000, 0));
	}

}
