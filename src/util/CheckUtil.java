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
	 * 检查手机号是否符合格式
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
	
	/**
	 * 是否只包含数字
	 * @param str
	 * @return
	 */
    public static boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]*"); 
        return pattern.matcher(str).matches();    
     }
    
    public static int sizeof(String str){
    	return str.length();
    }
    

	public static boolean isDouble(String str){
		String reg = "^[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

	public static void main(String[] args) {
		System.out.println(isDouble("啊"));
	}

}
