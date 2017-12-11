package cn.timeplan.hash;

import java.util.HashSet;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		String ip = "127.0.0.1";

		try {
			int sh1 = HashUtil.ELFHash(ip);
			System.out.println(sh1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ip2 = "127.0.0.2";
		int sh2;
		try {
			sh2 = HashUtil.java(ip2);
			System.out.println(sh2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<Long> hs = new HashSet();
		Random r = new Random();
		long start = System.currentTimeMillis();
		long end = 0l;
		for(int i=0;i<1000*100;i++){
			end = System.currentTimeMillis();
			long id= HashUtil.java(ip2) * r.nextLong();
			hs.add(id);
		}
		System.out.println(hs.size());
		System.out.println((end-start)+"s");
		
	}
}
