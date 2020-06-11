package sort;

import java.util.Arrays;

import util.SortUtils;

/**
 * 测试排序结果与效率
 *
 * @author XDXT
 */

public class Test {

	public static void main(String[] args) {
		Integer[] datas = SortUtils.randomArray(10000);

		compareSort(datas,
				new BubbleSort(),
				new SelectionSort(),
				new HeapSort());
	}

	public static void compareSort(Integer[] arrayDatas, Sort... sorts) {
		for (Sort sort : sorts) {
			sort.sort(SortUtils.arrayCopy(arrayDatas));
		}

		Arrays.sort(sorts);

		for (Sort sort2 : sorts) {
			// System.out.println(SortUtils.toString(sort2.getDatas()));
			System.out.println(sort2);
		}
	}
	
}
