package cn.timeplan.recurse.node;

public interface Iterator {

	public void first();
	
	public void next();
	
	public Object current();
	
	public boolean hasNext();
}
