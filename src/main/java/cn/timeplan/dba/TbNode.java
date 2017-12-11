package cn.timeplan.dba;

import java.util.ArrayList;

public class TbNode {

	private String tbName;
	private String pk;
	private ArrayList<String>fields;
	private ArrayList<TbNode> next;
	/**
	 * @param tbName
	 * @param fields
	 * @param next
	 */
	public TbNode(String tbName, ArrayList<String> fields, ArrayList<TbNode> next) {
		this.tbName = tbName;
		this.fields = fields;
		this.setNext(next);
	}
	public TbNode() {
		// TODO Auto-generated constructor stub
	}
	public String getTbName() {
		return tbName;
	}
	public void setTbName(String tbName) {
		this.tbName = tbName;
	}
	public ArrayList<String> getFields() {
		return fields;
	}
	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}

	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public ArrayList<TbNode> getNext() {
		return next;
	}
	public void setNext(ArrayList<TbNode> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "TbNode [tbName=" + tbName + ", fields=" + fields + ", next="
				+ getNext() + "]";
	}
	
	
}
