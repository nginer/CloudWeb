package com.test.fortest;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> list = new ArrayList<String[]>();
		String[] a = {"于","双","有"};
		String[] b = {"流","还","烟"};
		String[] c = {"郭","小","啊"};
		list.add(a);
		list.add(b);
		list.add(c);
		//JSONObject jobj = JSONObject.fromObject(list);
		JSONArray jarray = JSONArray.fromObject(list);
		String data = jarray.toString();
		System.out.println(data);
		System.out.println(jarray.get(0)+"这里！！！");

	}

}
