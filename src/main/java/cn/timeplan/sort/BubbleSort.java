package cn.timeplan.sort;

/**
 * 
 * @author zcl
 * 冒泡排序算法介绍
冒泡排序比插入排序更简单，把最大的元素逐步推到最高位(当前须处理子数组的最高位)。
依我的理解，冒泡排序是一个一层层筑顶的过程。顶筑好了，排序也就好了。冒泡排序的最坏运行时间是O(n2)，效率和插入排序一样。

冒泡排序算法Java实现
如《插入排序(Insertsort)之Java实现》一样，先实现一个数组工具类。代码如下
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		System.out.println("Before sort:");
		ArrayUtils.printArray(array);

		bubbleSort(array);

		System.out.println("After sort:");
		ArrayUtils.printArray(array);
	}

	public static void bubbleSort(int[] array) {
		if (array.length <= 1) {
			return;
		}

		int size = array.length;
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					ArrayUtils.exchangeElements(array, j, j + 1);
				}
			}
		}
	}
}