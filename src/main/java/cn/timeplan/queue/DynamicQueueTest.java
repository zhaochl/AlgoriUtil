package cn.timeplan.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * 队列与链表的示例
 * 求2的n次方
 * an放入队列
 * an+1 = an*2;
 * @author zcl
 * @2015.10.12
 */
public class DynamicQueueTest {

	public static void main(String[] args) {
		Queue <Integer> queue = new LinkedList<Integer>();
		//add seed a1=2
		queue.offer(2);
		System.out.println(queue.toString()+",size:"+queue.size());
		int time = 0;
		while(!queue.isEmpty() && time<6){
			int cur = queue.poll();
			System.out.println("cur:"+cur+",queue:"+queue.toString());
			queue.offer(cur*2);
			time++;
		}
	}
}
