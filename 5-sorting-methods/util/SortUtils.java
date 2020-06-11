package util;

import java.util.Random;

/**
 * 工具类
 *
 * @author XDXT
 */


public class SortUtils {

	/**
	 * 数组转成字符串
	 * @param array int型数组
	 */
	public static String toString(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < array.length-1; i++) {
			sb.append(array[i] + ", ");
		}
		sb.append(array[array.length-1] + "]");
		return sb.toString();
	}

	/**
	 * 数组转成字符串
	 * @param array Integer包装类数组
	 */
	public static String toString(Integer[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < array.length-1; i++) {
			sb.append(array[i] + ", ");
		}
		sb.append(array[array.length-1] + "]");
		return sb.toString();
	}

	/**
	 * 拷贝返回一个数值一样得到新数组
	 * @param array Integer包装类数组
	 */
	public static Integer[] arrayCopy(Integer[] array) {
		Integer[] newArray = new Integer[array.length];
		newArray = array.clone();
		return newArray;
	}

	/**
	 * 返回内容随机的数组
	 * @param length 数组长度
	 */
	public static Integer[] randomArray(int length) {
		Random r = new Random();
		Integer[] ra = new Integer[length];
		for (int i = 0; i < ra.length; i++) {
			ra[i] = r.nextInt(length*2);
		}
		return ra;
	}
	
}
