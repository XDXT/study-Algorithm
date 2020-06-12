package sort;

import util.SortUtils;

/**
 * 快速排序
 * @author XDXT
 *
 */

public class QuickSort extends Sort {

	@Override
	protected void sort() {
		quickSort(0, datas.length-1);

		// 默认赋值3次数据算1次交换
		swapCount /= 3;
	}

	/**
	 * 快排实现（有超出方法栈的可能）
	 * @param begin 数组开始位置
	 * @param end 数组末尾位置
	 */
	private void quickSort(int begin, int end) {
		// 数组只有1个元素完成排序
		if (end - begin < 1) { return; }

		// 确立构建轴点位置
		int pivotIndex = getPivot(begin, end);

		// 对轴点左右子序列排序
		quickSort(begin, pivotIndex-1);
		quickSort(pivotIndex+1, end);
	}

	/**
	 * 计算轴点位置与轴点左右数据归类
	 * @param begin 数组开始位置
	 * @param end 数组末尾位置
	 * @return
	 */
	private int getPivot(int begin, int end) {
		// 随机轴点元素选定，减少分类是左边或右边很多元素的情况
		Integer pivotValue = datas[SortUtils.randomNumber(begin, end)];

		// begin == end 时，轴点构建完成，数据归类完成
		while(begin < end) {
			// 默认 从end -> begin 查找
			while(begin < end) {
				if (compare(datas[end], pivotValue) > 0) {
					end--;
					continue;
				}
				datas[begin++] = datas[end];
				swapCount++;
				break;
			}
			// 从begin -> end 查找
			while(begin < end) {
				if (compare(datas[begin], pivotValue) < 0) {
					begin++;
					continue;
				}
				datas[end--] = datas[begin];
				swapCount++;
				break;
			}
		}

		datas[begin] = pivotValue;
		swapCount++;
		return begin;
	}
}
