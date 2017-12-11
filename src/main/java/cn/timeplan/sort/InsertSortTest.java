package cn.timeplan.sort;

/**
 * http://blog.csdn.net/kimylrong/article/details/17121519
 * @author zcl
 * 插入排序算法介绍
排序算法是最简单的算法，也是最基本的算法。顾名思义，插入排序就是把当前待排序的元素插入到一个已经排好序的列表里面。 一个非常形象的例子就是右手抓取一张扑克牌，并把它插入左手拿着的排好序的扑克里面。插入排序的最坏运行时间是O(n2)， 所以并不是最优的排序算法。特点是简单，不需要额外的存储空间，在元素少的时候工作得好。

插入排序算法Java实现
Java里面有很多数据类型，我们选取的是最简单的整数，但这并不失一般性。即使是自己定制化的对象，实现了java.lang.Comparable, 把对应的 大于号(>)以及小于号(<)换成compareTo即可。

由于需要频繁的操作以及打印数组，先写一个小的数组工具类。代码如下
 */
public class InsertSortTest {
	public static void insertSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}

		for (int i = 1; i < array.length; i++) {
			int currentValue = array[i];
			int position = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > currentValue) {
					array[j + 1] = array[j];
					position -= 1;
				} else {
					break;
				}
			}

			array[position] = currentValue;
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, -1, 0, -8, 2, 1 };
		ArrayUtils.printArray(array);
		insertSort(array);
		ArrayUtils.printArray(array);
	}
}
