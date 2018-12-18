package util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;

	public static java.util.Date toDate(java.sql.Timestamp t) {
		return new java.util.Date(t.getTime());
	}

	public static java.sql.Timestamp toTimestamp(java.util.Date d) {
		return new java.sql.Timestamp(d.getTime());
	}

	/**
	 * 获取今天，并且把时，分，秒和毫秒都置0。
	 * 
	 * @return
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();

	}

	/**
	 * 获取月初。使用Calendar获取本月第一天。
	 * 
	 * @return
	 */

	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	/**
	 * 获取月末
	 * 
	 * @return
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	/**
	 * 获取本月一共有多少天
	 * 
	 * @return
	 */
	public static int thisMonthTotalDay() {

		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();

		return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	/**
	 * 获取本月还剩多少天
	 * 
	 * @return
	 */
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	/**
	 * Date转String标准格式
	 * 
	 * @param time
	 * @return
	 */
	public static String formatDate(Date time) {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = dFormat.format(time);
		return formatDate;

	}

	/**
	 * String标准格式转化为Date
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		String strdate = formatDate(date);
		System.out.println(strdate);
		Date newdate = stringToDate(strdate);
		System.out.println(newdate);

	}
}