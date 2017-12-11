package cn.timeplan.matrix;

import java.io.IOException;

/**
 * 压缩稀疏矩阵并输出结果
 * 
 * @author zcl
 *
 */
public class MatrixCompress {

	public static void main(String args[]) throws IOException {
		final int _ROWS = 8; // 定义列数
		final int _COLS = 9; // 定义行数
		final int _NOTZERO = 8; // 定义稀疏矩阵中不为0的个数
		int i, j, tmpRW, tmpCL, tmpNZ;
		int temp = 1;
		int Sparse[][] = new int[_ROWS][_COLS]; // 声明稀疏矩阵
		int Compress[][] = new int[_NOTZERO + 1][3]; // 声明压缩矩阵
		for (i = 0; i < _ROWS; i++)
			// 将稀疏矩阵的所有元素设为0
			for (j = 0; j < _COLS; j++)
				Sparse[i][j] = 0;
		tmpNZ = _NOTZERO;
		for (i = 1; i < tmpNZ + 1; i++) {
			tmpRW = (int) (Math.random() * 100);
			tmpRW = (tmpRW % _ROWS);
			tmpCL = (int) (Math.random() * 100);
			tmpCL = (tmpCL % _COLS);
			if (Sparse[tmpRW][tmpCL] != 0) // 避免同一个元素设定两次数值而造成压缩矩阵中有0
				tmpNZ++;
			Sparse[tmpRW][tmpCL] = i; // 随机产生稀疏矩阵中非零的元素值
		}
		System.out.println("[稀疏矩阵的各个元素]"); // 打印稀疏矩阵的各个元素
		for (i = 0; i < _ROWS; i++) {
			for (j = 0; j < _COLS; j++)
				System.out.print(Sparse[i][j] + " ");
			System.out.println();
		}
		/* 开始压缩稀疏矩阵 */
		Compress[0][0] = _ROWS;
		Compress[0][1] = _COLS;
		Compress[0][2] = _NOTZERO;
		for (i = 0; i < _ROWS; i++)
			for (j = 0; j < _COLS; j++)
				if (Sparse[i][j] != 0) {
					Compress[temp][0] = i;
					Compress[temp][1] = j;
					Compress[temp][2] = Sparse[i][j];
					temp++;
				}
		System.out.println("[稀疏矩阵压缩后的内容]"); // 打印压缩矩阵的各个元素
		for (i = 0; i < _NOTZERO + 1; i++) {
			for (j = 0; j < 3; j++)
				System.out.print(Compress[i][j] + " ");
			System.out.println();
		}
	}
}
/**
[稀疏矩阵的各个元素]
5 0 6 0 9 0 0 0 0 
0 0 0 0 0 0 0 0 0 
4 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 1 0 8 0 
0 0 0 0 0 0 0 3 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 2 
[稀疏矩阵压缩后的内容]
8 9 8 
0 0 5 
0 2 6 
0 4 9 
2 0 4 
4 5 1 
4 7 8 
5 7 3 
7 8 2 
*/