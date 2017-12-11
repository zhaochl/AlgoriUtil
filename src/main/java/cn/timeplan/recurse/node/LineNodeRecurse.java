package cn.timeplan.recurse.node;

public class LineNodeRecurse {

	private String data;
	private LineNodeRecurse next;
	
	public void print(){
		LineNodeRecurse iterator = new LineNodeRecurse();
		iterator = this;
		while(iterator!=null){
			System.out.println(iterator.data);
			iterator = iterator.next;
		}
	}
	public static void main(String[] args) {
		LineNodeRecurse na = new LineNodeRecurse();
		LineNodeRecurse nb = new LineNodeRecurse();
		LineNodeRecurse nc = new LineNodeRecurse();
		na.data="a";
		nb.data="b";
		nc.data="c";
		
		na.next = nb;
		nb.next = nc;
		nc.next = null;
		
		na.print();
		
	}
}
