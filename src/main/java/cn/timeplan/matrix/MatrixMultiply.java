package cn.timeplan.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 矩阵相乘
 * @author zcl
 *
 */
public class MatrixMultiply {

	public static void MatrixMultiply(int arrA[][], int arrB[][], int arrC[][],
			int M, int N, int P) {
		int i, j, k, Temp;
		if (M <= 0 || N <= 0 || P <= 0) {
			System.out.println("[错误:维数M,N,P必须大于0]");
			return;
		}
		for (i = 0; i < M; i++)
			for (j = 0; j < P; j++) {
				Temp = 0;
				for (k = 0; k < N; k++)
					Temp = Temp + arrA[i][k] * arrB[k][j];
				arrC[i][j] = Temp;
			}
	}

	public static void main(String args[]) throws IOException

	{
		int M, N, P;
		int i, j;
		String strM;
		String strN;
		String strP;
		String tempstr;
		BufferedReader keyin = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("请输入矩阵A的维数(M,N): ");
		System.out.print("请先输入矩阵A的M值: ");
		strM = keyin.readLine();
		M = Integer.parseInt(strM);
		System.out.print("接着输入矩阵A的N值: ");
		strN = keyin.readLine();
		N = Integer.parseInt(strN);
		int A[][] = new int[M][N];
		System.out.println("[请输入矩阵A的各个元素]");
		System.out.println("注意！每输入一个值按下Enter键确认输入");
		for (i = 0; i < M; i++)
			for (j = 0; j < N; j++) {
				System.out.print("a" + i + j + "=");
				tempstr = keyin.readLine();
				A[i][j] = Integer.parseInt(tempstr);
			}
		System.out.println("请输入矩阵B的维数(N,P): ");
		System.out.print("请先输入矩阵B的N值: ");
		strN = keyin.readLine();
		N = Integer.parseInt(strN);
		System.out.print("接着输入矩阵B的P值: ");
		strP = keyin.readLine();
		P = Integer.parseInt(strP);
		int B[][] = new int[N][P];
		System.out.println("[请输入矩阵B的各个元素]");
		System.out.println("注意！每输入一个值按下Enter键确认输入");
		for (i = 0; i < N; i++)
			for (j = 0; j < P; j++) {
				System.out.print("b" + i + j + "=");
				tempstr = keyin.readLine();
				B[i][j] = Integer.parseInt(tempstr);
			}
		int C[][] = new int[M][P];
		MatrixMultiply(A, B, C, M, N, P);
		System.out.println("[AxB的结果是]");
		for (i = 0; i < M; i++) {
			for (j = 0; j < P; j++) {
				System.out.print(C[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}
	}
}
/**
 请输入矩阵A的维数(M,N): 
请先输入矩阵A的M值: 2
接着输入矩阵A的N值: 2
[请输入矩阵A的各个元素]
注意！每输入一个值按下Enter键确认输入
a00=3
a01=2
a10=3
a11=4
请输入矩阵B的维数(N,P): 
请先输入矩阵B的N值: 2
接着输入矩阵B的P值: 3
[请输入矩阵B的各个元素]
注意！每输入一个值按下Enter键确认输入
b00=1
b01=2
b02=3
b10=4
b11=2
b12=1
[AxB的结果是]
11	10	11	
19	14	13
 */
