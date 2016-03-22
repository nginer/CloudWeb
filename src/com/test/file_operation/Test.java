package com.test.file_operation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) throws DocumentException {
		/*// TODO Auto-generated method stub
		File f_test = new File("D://AAA//BBB//CCC.xml");
		try {
			f_test.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		HandleFile hf = new HandleFile();
		hf.createFile("D://gg", "gou.xml");
		String xmlpath = "D://gg/gou.xml";
		/*hf.createFile("D://ggggg//hhhhhhhhhhh", "iiiiiiiiiii.xml");
		hf.createFolder("D://jjjjjjjjjjj//kkkkkkkkkk");
		hf.createFolder("D://llllllll");*/
		//hf.deleteFile("D://jjjjjjjjjjj//aa吧.txt");
		/*HandleXML hdx = new HandleXML();
		hdx.writeRoot2XML("D://wokao.xml", "hahahhhhh");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("D://wokao.xml"));
		Element root = doc.getRootElement();
		System.out.println(root.getName()+"!!!!!!!!!!!1");*/
		/*ArrayList<String> list = new ArrayList<String>(){{add("xixi");add("hah");}};
		
		System.out.println(list.get(0).getClass().getName());*/
	  //  HandleXML_trash hx = new HandleXML_trash();
	/*	hx.writeRoot2XML(xmlpath, "service");
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> hm = new HashMap<String, String>() ;
		hm.put("ID", "123");
		al.add(hm);
		hm.put("servicename", "webgis");
		al.add(hm);
		hm.put("key", "aa,bb,cc");
		al.add(hm);
		hm.put("intro", "very good");
		al.add(hm);
		
				//new ArrayList<HashMap<String,String>>(){{put("ID","123");put("servicename","webgis");put("key","ni,wo,ta");}};
		hx.write2XML(xmlpath, "service", al);*/
		ArrayList<String> list = new ArrayList<String>(){{add("xixi");add("hah");}};
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> a2 = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> hm1 = new HashMap<String, String>() ;
		HashMap<String,String> hm2 = new HashMap<String, String>() ;
		HashMap<String,String> hm3 = new HashMap<String, String>() ;
		HashMap<String,String> hm4 = new HashMap<String, String>() ;
		hm1.put("ID", "123");
		al.add(hm1);
		hm2.put("servicename", "webgis");
		al.add(hm2);
		hm3.put("key", "aa,bb,cc");
		al.add(hm3);
		hm4.put("intro", "very good");
		al.add(hm4);
		//a2.add(hm1);
		//hm1.put("11111", "123");
		
		//a2.add(hm1);
		System.out.println(al);
		System.out.println(a2);
		System.out.println(al.get(0).getClass().getName());
		System.out.println(list.get(0).getClass().getName());
		/*Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println("11111111111111");
			//Element elem = root.addElement( (String) it.next());
			System.out.println((String) it.next());
			System.out.println("shoibna");
			System.out.println("11111111111111");
			}*/
		//hx.write2XML(xmlpath, "service", list);
	}

}
