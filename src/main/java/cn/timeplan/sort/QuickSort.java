package cn.timeplan.sort;

/**
 * 快速排序算法介绍
快速排序和归并排序都使用分治法来设计算法，区别在于归并排序把数组分为两个基本等长的子数组，分别排好序之后还要进行归并(Merge)操作，而快速排序拆分子数组的时候显得更有艺术，取一个基准元素，拆分之后基准元素左边的元素都比基准元素小，右边的元素都不小于基准元素，这样只需要分别对两个子数组排序即可，不再像归并排序一样需要归并操作。基准元素的选取对算法的效率影响很大，最好的情况是两个子数组大小基本相当。为简单起见，我们选择最后一个元素，更高级的做法可以先找一个中位数并把中位数与最后一个元素交换，之后再进行相同的操作步骤。拆分是快速排序的核心。快速排序的最坏运行时间是O(n2)，但期望的运行时间是O(nlgn)。

快速排序算法Java实现
把数组拆分为两个子数组加上一个基准元素: 选取最后一个元素作为基准元素，index变量记录最近一个小于基准元素的元素所在的位置，初始化为start- 1，发现新的小于基准元素的元素，index加1。从第一个元素到倒数第二个元素，依次与基准元素比较，小于基准元素，index加1，交换位置index和当前位置的元素。循环结束之后index+1得到基准元素应该在的位置，交换index+1和最后一个元素。
分别排序[start, index], 和[index+2, end]两个子数组
如《插入排序(Insertsort)之Java实现》一样，先实现一个数组工具类。代码如下
 * @author zcl
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		System.out.println("Before sort:");
		ArrayUtils.printArray(array);

		quickSort(array);

		System.out.println("After sort:");
		ArrayUtils.printArray(array);
	}

	public static void quickSort(int[] array) {
		subQuickSort(array, 0, array.length - 1);
	}

	private static void subQuickSort(int[] array, int start, int end) {
		if (array == null || (end - start + 1) < 2) {
			return;
		}

		int part = partition(array, start, end);

		if (part == start) {
			subQuickSort(array, part + 1, end);
		} else if (part == end) {
			subQuickSort(array, start, part - 1);
		} else {
			subQuickSort(array, start, part - 1);
			subQuickSort(array, part + 1, end);
		}
	}

	private static int partition(int[] array, int start, int end) {
		int value = array[end];
		int index = start - 1;

		for (int i = start; i < end; i++) {
			if (array[i] < value) {
				index++;
				if (index != i) {
					ArrayUtils.exchangeElements(array, index, i);
				}
			}
		}

		if ((index + 1) != end) {
			ArrayUtils.exchangeElements(array, index + 1, end);
		}

		return index + 1;
	}
}