package sort;

/**
 * 冒泡排序
 *
 * @author XDXT
 */

public class BubbleSort extends Sort {

	@Override
	protected void sort() {
		// 如果数据末尾部分已经有序，只需排序前面部分 [记录最后1次位置]
		for (int i = datas.length-1; i > 0; i--) {
			int sortedIndex = 0;
			for (int j = 0; j < i; j++) {
				if (compare(j, j+1) > 0) {
					swap(j, j+1);
					sortedIndex = j+1;
				}
			}
			// 当数组有序时，sortedIndex会让循环提前停止
			i = sortedIndex;
		}
	}

}
