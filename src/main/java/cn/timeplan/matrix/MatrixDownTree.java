package cn.timeplan.matrix;

/**
 * 数组的应用-下三角矩阵
 * 
 * @author zcl
 *
 */
public class MatrixDownTree {
	private int[] arr;
	private int array_size;

	public MatrixDownTree (int[][] array) {
		array_size = array.length;
		arr = new int[array_size * (1 + array_size) / 2];
		int index = 0;
		for (int i = 0; i < array_size; i++) {
			for (int j = 0; j < array_size; j++) {
				if (array[i][j] != 0)
					arr[index++] = array[i][j];
			}
		}
	}

	public int getValue(int i, int j) {
		int index = array_size * i - i * (i + 1) / 2 + j;
		return arr[index];
	}

	public static void main(String[] args) {
		int[][] array = { { 76, 0, 0, 0, 0 }, { 54, 51, 0, 0, 0 },
				{ 23, 8, 26, 0, 0 }, { 43, 35, 28, 18, 0 },
				{ 12, 9, 14, 35, 46 } };
		MatrixDownTree Array_object = new MatrixDownTree(array);
		int i = 0, j = 0;
		System.out.println("==========================================");
		System.out.println("下三角形矩阵：");
		for (i = 0; i < Array_object.array_size; i++) {
			for (j = 0; j < Array_object.array_size; j++)
				System.out.print("\t" + array[i][j]);
			System.out.println();
		}
		System.out.println("==========================================");
		System.out.println("以一维的方式表示：");
		System.out.print("\t" + "[");
		for (i = 0; i < Array_object.array_size; i++) {
			for (j = i; j < Array_object.array_size; j++)
				System.out.print(" " + Array_object.getValue(i, j));
		}
		System.out.print(" ]");
		System.out.println();
	}
}
/**
==========================================
下三角形矩阵：
	76	0	0	0	0
	54	51	0	0	0
	23	8	26	0	0
	43	35	28	18	0
	12	9	14	35	46
==========================================
以一维的方式表示：
	[ 76 54 51 23 8 26 43 35 28 18 12 9 14 35 46 ]

*/
