package cn.timeplan.recurse.json;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.json.JSONObject;

public class JSONFilterRecurse {

	
	public static void filter(JSONObject jo){
		Iterator i = jo.keys();
		while(i.hasNext()){
			String key = (String) i.next();
			Object value = jo.get(key);
			if(value instanceof JSONObject){
				JSONObject jotmp = (JSONObject) value;
				filter(jotmp);
			}else if(value instanceof String){
				jo.put(key, value.toString().replace("\n","").replace("\t", "").replace(",", ""));
			}
		}
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
       
		JSONObject jo = new JSONObject();
		jo.put("a", "ss\tadf");
		System.out.println(jo.toString());
		JSONFilterRecurse.filter(jo);
		System.out.println(jo.toString());
		
		JSONObject jotmp = new JSONObject();
		jotmp.put("b", "bbb\n\taa");
		jo.put("ob", jotmp);
		System.out.println(jo.toString());
		JSONFilterRecurse.filter(jo);
		System.out.println(jo.toString());
	}
}
