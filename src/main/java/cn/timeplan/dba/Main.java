package cn.timeplan.dba;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * user uid,uname,gid
	 * group gid,gname
	 * product pid,pname
	 * order oid,uid,pid
	 * supply sid,uid,pid
	 * puchase puid,uid,pid
	 * 
	 * @param args
	 */
	public static Dba genDBAMack() {
		
		//基本表信息结构的构造
		//user uid,uname,gid
		TbNode user = new TbNode();
		user.setTbName("user");
		user.setPk("uid");
		ArrayList<String> userField = new ArrayList();
		userField.add("uid");
		userField.add("uname");
		userField.add("gid");
		user.setFields(userField);
		
		//group gid,gname
		TbNode group = new TbNode();
		group.setTbName("group");
		group.setPk("gid");
		ArrayList<String> groupField = new ArrayList();
		groupField.add("gid");
		groupField.add("gname");
		group.setFields(groupField);
		
		//product pid,pname
		TbNode product = new TbNode();
		product.setTbName("product");
		product.setPk("pid");
		ArrayList<String> productField = new ArrayList();
		productField.add("pid");
		productField.add("pname");
		product.setFields(productField);
		//order oid,uid,pid
		TbNode order = new TbNode();
		order.setTbName("order");
		order.setPk("oid");
		ArrayList<String> orderField = new ArrayList();
		orderField.add("oid");
		orderField.add("uid");
		orderField.add("pid");
		order.setFields(orderField);
		//supply sid,uid,pid
		TbNode supply = new TbNode();
		supply.setTbName("supply");
		supply.setPk("sid");
		ArrayList<String> supplyField = new ArrayList();
		supplyField.add("sid");
		supplyField.add("uid");
		supplyField.add("pid");
		supply.setFields(supplyField);
		
		//puchase puid,uid,pid
		TbNode puchase = new TbNode();
		puchase.setTbName("puchase");
		puchase.setPk("puid");
		ArrayList<String> puchaseField = new ArrayList();
		puchaseField.add("puid");
		puchaseField.add("uid");
		puchaseField.add("pid");
		puchase.setFields(puchaseField);
		
		///////////////////////////////////
		//puchase
		ArrayList<TbNode> puchaseNext = new ArrayList();
		puchaseNext.add(user);
		puchaseNext.add(product);
		puchase.setNext(puchaseNext);
		//order
		ArrayList<TbNode> orderNext = new ArrayList();
		orderNext.add(user);
		orderNext.add(product);
		order.setNext(orderNext);
		//supply
		ArrayList<TbNode> supplyNext = new ArrayList();
		supplyNext.add(user);
		supplyNext.add(product);
		supply.setNext(supplyNext);
		//user
		ArrayList<TbNode> userNext = new ArrayList();
		userNext.add(group);
		user.setNext(userNext);
		//group
		group.setNext(null);
		//product
		product.setNext(null);
		//////////////////////
		Dba dba = new Dba();
		dba.setDbName("ymt360");
		ArrayList tbList = new ArrayList();
		tbList.add(user);
		tbList.add(group);
		tbList.add(product);
		tbList.add(order);
		tbList.add(puchase);
		tbList.add(supply);
		dba.setTbs(tbList);
		System.out.println("dba create success.");
		return dba;
	}
	public static void analyseDbaRecursion(TbNode tb,ArrayList<TbNode>tbList){
		 
		for(int i=0;i<tbList.size();i++){
			System.out.println("-----start"+i+"-----");
			TbNode tbTmp = tbList.get(i);
			System.out.println("Node:"+tbTmp.getTbName());
			if(tbTmp.getNext()!=null){
				analyseDbaRecursion(tbTmp,tbTmp.getNext());
			}else{
				//System.out.println("Node:"+tbTmp.getTbName()+" ");
			}
		}
	}
	public static void main(String[] args) {
		Dba db = genDBAMack();
		ArrayList tbList = db.getTbs();
		TbNode dbaRoot = new TbNode();
		dbaRoot.setTbName("dba");
		dbaRoot.setFields(null);
		dbaRoot.setNext(tbList);
		analyseDbaRecursion(dbaRoot,tbList);
	}
}
