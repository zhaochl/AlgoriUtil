package cn.timeplan.search.binSearch;

/**
 * 二分查找又称折半查找，它是一种效率较高的查找方法。 　　【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
 * 
 * @author Administrator
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] src = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(binarySearch(src, 7));
		System.out.println(binarySearch(src, 7, 0, src.length - 1));
		System.out.println(binarySearch2(src, 0, src.length - 1, 7));
	}

	/**
	 * * 二分查找算法 * *
	 * 
	 * @param srcArray
	 *            有序数组 *
	 * @param des
	 *            查找元素 *
	 * @return des的数组下标，没找到返回-1
	 */
	public static int binarySearch(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找特定整数在整型数组中的位置(递归)
	 *
	 * @paramdataset
	 * @paramdata
	 * @parambeginIndex
	 * @paramendIndex
	 * @returnindex
	 */
	public static int binarySearch(int[] dataset, int data, int beginIndex,
			int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

	/**
	 * 网上参照-修改版
	 * 
	 * @param Array
	 * @param low
	 * @param high
	 * @param key
	 *            要找的值
	 * @return
	 */
	public static int binarySearch2(int Array[], int low, int high, int key) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (key < Array[mid])
			return binarySearch2(Array, low, mid - 1, key);
		else if (key > Array[mid])
			return binarySearch2(Array, mid + 1, high, key);
		else
			return mid;
	}

}