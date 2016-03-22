package com.test.fortest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, String>> lm = new ArrayList<>();
		lm.add(new HashMap<String, String>(){{put("1","111");put("2","222");}});
		lm.add(new HashMap<String, String>(){{put("3","333");put("4","444");}});
		System.out.println("``````````````````````````");
		System.out.println(lm.get(0));
		System.out.println(lm.get(1));
		System.out.println("``````````````````````````");
		ArrayList<String> list = new ArrayList<String>(){{add("str01");add("str02");}};
		System.out.println(lm);
		System.out.println(list);
	}

}
