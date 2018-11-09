package util;

public class NumberUtil {

	public static double sum(double[] array){
		double sum = 0;
		for (double d : array) {
			sum+=d;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		double[] a = {12.3,11.2,1235,21.14};
		System.out.println(sum(a));
	}
	
}
