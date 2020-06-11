package sort;
/**
 * 堆排序
 *
 * @author XDXT
 */
public class HeapSort extends Sort {
	private int heapSize;

	@Override
	protected void sort() {
		// 根据数组，创建堆
		heapSize = datas.length;
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}
		// 当size>1时，重复做以下
		while(heapSize > 1) {
			// 交换堆顶与堆尾，尺寸-1
			swap(0, --heapSize);
			// 对0位置进行1次siftDown(恢复堆性质)
			siftDown(0);
		}
	}

	private void siftDown(int index) {
		Integer element = datas[index];

		int half = heapSize >> 1;
		// 非叶子节点
		while(index < half) {
			// 默认左边跟父节点比
			int childIndex = (index << 1) + 1;
			Integer child = datas[childIndex];

			int rightIndex = childIndex + 1;
			// 右节点比左节点大
			if (rightIndex < heapSize &&
					compare(datas[rightIndex], child) > 0) {
				child = datas[childIndex = rightIndex];
			}
			// 比子节点大
			if (compare(element, child) >= 0) {
				break;
			}

			datas[index] = child;
			index = childIndex;
		}
		datas[index] = element;
	}
}
