package cn.timeplan.recurse.series;
/**
 * 
 * @author zcl
 * @date 2015-7-7
 * @description an=a0*(n-1)*2
 * 1,2,4,8...
 */
public class MutiSeriesRecurse {

	public static int an;
	
	public static int getAn(int n){
		if(n>0){
			an = getAn(n-1)*2;
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
