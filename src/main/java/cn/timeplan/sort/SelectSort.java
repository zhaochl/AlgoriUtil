package cn.timeplan.sort;

/**
 * 
 * @author zcl
 *选择排序算法介绍
选择排序与冒泡排序非常的相似，都是一层层筑顶的过程，不同点在于冒泡排序会频繁的互换位置，
而选择排序只是记录最大元素的位置，并与顶互换，只需交换一次。所以选择排序与冒泡排序相比时间常数会更小，更有效率，尽管他们的最坏运行时间都是O(n2)。

选择排序算法Java实现
如《插入排序(Insertsort)之Java实现》一样，先实现一个数组工具类。代码如下
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, 8 };

		System.out.println("Before sort:");
		ArrayUtils.printArray(array);

		selectSort(array);

		System.out.println("After sort:");
		ArrayUtils.printArray(array);
	}

	public static void selectSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}

		int size = array.length;
		for (int i = size - 1; i > 0; i--) {
			int maxIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				ArrayUtils.exchangeElements(array, i, maxIndex);
			}
		}
	}
}