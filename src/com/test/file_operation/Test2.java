package com.test.file_operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Test2 {

	public static void main(String[] args) throws IOException, DocumentException {
		// TODO Auto-generated method stub
		
		String xmlpath = "D://gg/gou.xml";
		ArrayList<String> list = new ArrayList<String>(){{add("xixi");add("hah");}};
		ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();
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
		System.out.println(al);
		System.out.println(al.get(0).getClass().getName());
		System.out.println(list.get(0).getClass().getName());
		if(list.get(0).getClass().getName()=="java.lang.String"){System.out.println("wakkkk");}
		
		HandleXML hx2 = new HandleXML();
		hx2.write2XML(xmlpath, "BBBB", al);
		/*hx2.write2XML(xmlpath, "", list);*/
		/*Element root = null;
		Document doc = null;
		try {
			HandleXML hx = new HandleXML();
			//hx.writeRoot2XML(xmlpath, "service");
			SAXReader reader = new SAXReader();
			doc = reader.read(new File(xmlpath));
			root = doc.getRootElement();
			//root.addElement("AAA");
			//root.addElement("BBBB");
			Element elem_AAA= root.element("AAA");
			System.out.println(elem_AAA+"...........");
			elem_AAA.addElement("CCC22233333333");
			System.out.println(root.getName()+">>>>>>>>>");
			root.addElement("AAA");
			root.addElement("BBBB");
			XMLWriter writer = new XMLWriter(new FileWriter(xmlpath),
			OutputFormat.createPrettyPrint());
			System.out.println("写入这一步！！");
			writer.write(doc);
			System.out.println(doc);
			writer.flush();
			writer.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
}