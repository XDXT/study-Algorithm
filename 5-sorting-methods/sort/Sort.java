package sort;
/**
 * 
 * 
 * @author XDXT
 */

public abstract class Sort implements Comparable<Sort> {
	protected Integer[] datas;
	protected int cmpCount;
	protected int swapCount;
	protected long costTime;
	
	/**
	 * 对外开放排序接口
	 * @param array 数据
	 */
	public void sort(Integer[] array) {
		if (null == array || array.length <= 1) {
			return;
		}
		this.datas = array;
		costTime = System.currentTimeMillis();
		sort();
		costTime = System.currentTimeMillis() - costTime;
	}
	
	protected abstract void sort();
	
	/**
	 * 根据元素位置比较数值，用于记录比较次数
	 * @param index1 
	 * @param index2
	 * @return
	 */
	protected int compare(int index1, int index2) {
		cmpCount++;
		return datas[index1] - datas[index2];
	}
	
	/**
	 * 直接比较数值，用于记录比较次数
	 * @param v1 
	 * @param v2
	 * @return
	 */
	protected int compare(Integer v1, Integer v2) {
		cmpCount++;
		return v1 - v2;
	}

	/**
	 * 根据元素位置交换数值，用于记录交换次数
	 * @param index1
	 * @param index2
	 */
	protected void swap(int index1, int index2) {
		swapCount++;
		int temp = datas[index1];
		datas[index1] = datas[index2];
		datas[index2] = temp;
	}
	
	/**
	 * 格式化数字为更容易看出的字符串
	 * @param number 数字
	 * @return
	 */
	protected String formatNumber(int number) {
		if (number < 10000) {
			return String.valueOf(number);
		}
		if (number >= 1.0E4 && number < 1.0E8) {
			return String.valueOf((double)number/10000) + "万";
		}
		return String.valueOf((double)number/1.0E8) + "亿";
	}
	
	/**
	 * 返回数组排序结果
	 * true: 排序正确
	 * false： 排序错误
	 */
	protected boolean isRightSort() {
		if (datas == null || datas.length <= 1) {
			return true;
		}
		for (int i = 0; i < datas.length-1; i++) {
			if (datas[i] > datas[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 重写toString，记录排序信息
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n【" + this.getClass().getSimpleName() + "】\n");
		sb.append("花费时间: \t" + costTime + "(ms)\n");
		sb.append("比较次数: \t" + formatNumber(cmpCount) + "\n");
		sb.append("交换次数: \t" + formatNumber(swapCount) + "\n");
		sb.append("排序结果: \t" + isRightSort() + "\n");
		sb.append("-----------------------------");
		return sb.toString();
	}
	
	/**
	 * 获取排序后的数组
	 * @return Integer[]
	 */
	public Integer[] getDatas() {
		return datas;
	}
	
	/**
	 * 用于排序类的排序，便于按性能查看
	 */
	@Override
	public int compareTo(Sort o) {
		int result = (int)(this.costTime - o.costTime);
		if (result != 0) { return result; }
		
		result = this.cmpCount - o.cmpCount;
		if (result != 0) { return result; }
		
		return this.swapCount - o.swapCount;
	}
	
}
