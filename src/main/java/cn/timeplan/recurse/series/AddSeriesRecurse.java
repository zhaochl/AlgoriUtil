package cn.timeplan.recurse.series;
/**
 * 
 * @author zcl
 * @date 2015-7-7
 * @description an=a0+(n-1)*5
 * 1,6,11,...
 */
public class AddSeriesRecurse {

	public static int an;
	
	public static int getAn(int n){
		if(n>0){
			an = getAn(n-1)+5;
		}else{
			return 0;
		}
		return an;
	}
	public static int getSum(int n){
		int sum = 0;
		if(n==1){
			return getAn(0);
		}else{
			sum+=getSum(n-1)+getAn(n-1);
		}
		return sum;
	}
	public static int getAnp(int n){
		int anp=0;
		if(n>0){
			anp = getAn(n-1)+5;
		}else{
			return 0;
		}
		return anp;
	}
	public static void main(String[] args) {
		
		System.out.println("a0="+getAn(0)+",a1="+getAn(1)+",a2="+getAn(2));
//		for(int i=0;i<10;i++){
//			System.out.println("a"+i+"="+getAn(i));
//		}
//		for(int i=0;i<10;i++){
//			System.out.println("a"+i+"="+getAnp(i));
//		}
		//getSum n==1 为下限，这里要从i=1开始，否则会出现stackOverFlow错误
		for(int i=1;i<5;i++){
			System.out.println("sum"+i+"="+getSum(i));
		}
	}
	
}
