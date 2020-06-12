package sort;
/**
 * 插入排序
 * @author XDXT
 *
 */
public class InsertionSort extends Sort {
	
	/**
	 * 数据往后覆盖会比，数据交换更高效
	 */
	@Override
	protected void sort() {
		for (int i = 1; i < datas.length; i++) {
			int j = i;
			Integer temp = datas[j];
			for (; j > 0; j--) {
				if (compare(temp, datas[j-1]) < 0) {
					datas[j] = datas[j-1];
					swapCount++;
					continue;
				}
				// 当已经比前面的数字大了，就没必要看前面剩余的数据
				if (compare(j, j-1) > 0) {
					break;
				}
			}
			datas[j] = temp;
		}
		
		// 原来一次交换有3次数据赋值
		swapCount /= 3;
	}
}
