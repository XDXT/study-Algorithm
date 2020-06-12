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
	
	protected int compare(int index1, int index2) {
		cmpCount++;
		return datas[index1] - datas[index2];
	}
	
	protected int compare(Integer v1, Integer v2) {
		cmpCount++;
		return v1 - v2;
	}

	
	protected void swap(int index1, int index2) {
		swapCount++;
		int temp = datas[index1];
		datas[index1] = datas[index2];
		datas[index2] = temp;
	}
	
	protected String formatNumber(int number) {
		if (number < 10000) {
			return String.valueOf(number);
		}
		if (number >= 1.0E4 && number < 1.0E8) {
			return String.valueOf((double)number/10000) + "万";
		}
		return String.valueOf((double)number/1.0E8) + "亿";
	}
	
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
	
	public Integer[] getDatas() {
		return datas;
	}
	
	@Override
	public int compareTo(Sort o) {
		int result = (int)(this.costTime - o.costTime);
		if (result != 0) { return result; }
		
		result = this.cmpCount - o.cmpCount;
		if (result != 0) { return result; }
		
		return this.swapCount - o.swapCount;
	}
	
}
