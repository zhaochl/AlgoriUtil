package cn.timeplan.dba;

import java.util.ArrayList;

public class Dba {

	private String dbName;
	private ArrayList<TbNode> tbs;
	
	/**
	 * @param dbName
	 * @param tbs
	 */
	public Dba(String dbName, ArrayList<TbNode> tbs) {
		this.dbName = dbName;
		this.tbs = tbs;
	}
	

	public Dba() {
		// TODO Auto-generated constructor stub
	}


	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public ArrayList<TbNode> getTbs() {
		return tbs;
	}
	public void setTbs(ArrayList<TbNode> tbs) {
		this.tbs = tbs;
	}
}
