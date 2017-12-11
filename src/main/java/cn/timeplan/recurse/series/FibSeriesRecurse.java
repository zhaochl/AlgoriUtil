package cn.timeplan.recurse.series;

/**
 * 
 * @author zcl
 * @date 2015-7-7
 * @description a(n)=a(n-2)+a(n-1),a1=1,a2=1
 * 
 *              a1=1 a2=1 a3=2 a4=3 a5=5 a6=8
 */
public class FibSeriesRecurse {

	public static int an;

	public static int getAn(int n) {
		try {
			if (n == 1) {
				return 1;
			} else if (n == 2) {
				return 1;
			} else {
				an = getAn(n - 1) + getAn(n - 2);
			}
		} catch (java.lang.StackOverflowError e) {
			System.out.println("已经超出下限了,n=1,n=2,n=3...");
			System.exit(-1);
			// e.printStackTrace();
		}
		return an;
	}

	public static void main(String[] args) {
		//报错测试
		//System.out.println("a0=" + getAn(0) + ",a1=" + getAn(1) + ",a2="+ getAn(2));
		// 要从n==1开始，否则会报错stackOverFlow
		for (int i = 1; i < 10; i++) {
			System.out.println("a" + i + "=" + getAn(i));
		}
	}

}
