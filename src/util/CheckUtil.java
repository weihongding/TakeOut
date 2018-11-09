package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Customer;

public class CheckUtil {

	public static boolean Password_Register(String password) {

		return true;
	}

	/**
	 * 某个表的某一列下某个数据的个数
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

	public static void main(String[] args) {
		int count = existence_String("apply", "bid", "5");
		System.out.println(count);
	}

}
