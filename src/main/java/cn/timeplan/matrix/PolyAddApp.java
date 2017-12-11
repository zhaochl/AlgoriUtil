package cn.timeplan.matrix;

import java.io.IOException;
/**
 * 将两个最高次方相等的多项式相加后输出结果
 * @author zcl
 *
 */
public class PolyAddApp {
	final static int ITEMS = 6;

	public static void main(String args[]) throws IOException {
		int[] PolyA = { 4, 3, 7, 0, 6, 2 }; // 声明多项式A
		int[] PolyB = { 4, 1, 5, 2, 0, 9 }; // 声明多项式B
		System.out.print("多项式A=> ");
		PrintPoly(PolyA, ITEMS); // 打印多项式A
		System.out.print("多项式B=> ");
		PrintPoly(PolyB, ITEMS); // 打印多项式B
		System.out.print("A+B => ");
		PolySum(PolyA, PolyB); // 多项式A+多项式B
	}

	public static void PrintPoly(int Poly[], int items) {
		int i, MaxExp;
		MaxExp = Poly[0];
		for (i = 1; i <= Poly[0] + 1; i++) {
			MaxExp--;
			if (Poly[i] != 0) // 如果该项式为0就跳过
			{
				if ((MaxExp + 1) != 0)
					System.out.print(Poly[i] + "X^" + (MaxExp + 1));
				else
					System.out.print(Poly[i]);
				if (MaxExp >= 0)
					System.out.print('+');
			}
		}
		System.out.println();
	}

	public static void PolySum(int Poly1[], int Poly2[]) {
		int i;
		int result[] = new int[ITEMS];
		result[0] = Poly1[0];
		for (i = 1; i <= Poly1[0] + 1; i++)
			result[i] = Poly1[i] + Poly2[i]; // 等幂的系数相加
		PrintPoly(result, ITEMS);
	}
}
/**
多项式A=> 3X^4+7X^3+6X^1+2
多项式B=> 1X^4+5X^3+2X^2+9
A+B => 4X^4+12X^3+2X^2+6X^1+11
*/