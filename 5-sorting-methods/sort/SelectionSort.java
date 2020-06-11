package sort;
/**
 * 选择排序
 *（每次找出最大的与末尾交换）
 * @author XDXT
 */

public class SelectionSort extends Sort {

	@Override
	protected void sort() {
		for (int i = 0; i < datas.length; i++) {
			int maxIndex = 0;
			for (int j = 1; j < datas.length-i; j++) {
				if (compare(maxIndex, j) < 0) {
					maxIndex = j;
				}
			}
			swap(datas.length-i-1, maxIndex);
		}
	}
}
