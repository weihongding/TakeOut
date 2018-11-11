package util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

	private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");

	/**
	 * 随机得到一个范围内的整数
	 * 
	 * @see 闭区间
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}

	/**
	 * 随机生成手机号
	 * 
	 * @return
	 */
	public static String getTelephone() {
		int index = getNum(0, telFirst.length - 1);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + thrid;
	}

	/**
	 * 计算double集合的和
	 * 
	 * @param array
	 * @return
	 */
	public static double sum(List<Double> array) {
		double sum = 0;
		for (double d : array) {
			sum += d;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(getNum(-100, 100));
	}

}
