package sort;

import java.util.Arrays;

import util.SortUtils;

public class Test {

	public static void main(String[] args) {
		Integer[] datas = SortUtils.randomArray(15000);

		compareSort(datas,
//				new BubbleSort(),
				new SelectionSort(),
				new HeapSort(),
				new InsertionSort(),
				new QuickSort()
				);
	}
	
	public static void compareSort(Integer[] arrayDatas, Sort... sorts) {
		for (Sort sort : sorts) {
			sort.sort(SortUtils.arrayCopy(arrayDatas));
		}
		
		Arrays.sort(sorts);
		
		for (Sort sort2 : sorts) {
//			System.out.println(SortUtils.toString(sort2.getDatas()));
			System.out.println(sort2);
		}
		
	}

}
