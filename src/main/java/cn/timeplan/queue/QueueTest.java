package cn.timeplan.queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
    	//LinkedList
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
    	//当队列为空时候，使用add方法会报错，而offer方法会返回false
    	//作为List使用时,一般采用add / get方法来 压入/获取对象
    	//作为Queue使用时,才会采用 offer/poll/take等方法
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素 
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素 
        for(String q : queue){
            System.out.println(q);
        }
        
    }
}