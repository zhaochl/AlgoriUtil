package cn.timeplan.recurse.series;
/**
 * 
 * @author zcl
 * @date 2015-7-7
 * @description a(n)=n-1*a(n-1)
 * 1,6,11,16...
 */
public class FactSeriesRecurse {

	public static int an;
	
	public static int getAn(int n){
		if(n>0){
			an = n * getAn(n-1);
		}else{
			return 1;
		}
		return an;
	}
	public static void main(String[] args) {
		
		System.out.println("a0="+getAn(0)+",a1="+getAn(1)+",a2="+getAn(2));
		for(int i=0;i<10;i++){
			System.out.println("a"+i+"="+getAn(i));
		}
	}
	
}
