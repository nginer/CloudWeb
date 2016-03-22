package com.test.fortest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.test.file_operation.HandleXML;

public class XMLt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("E:\\TEST\\sss.xml"));
			Document doc1 = reader.read(new File("E:\\TEST\\aaa.xml"));
			Element root = doc.getRootElement();
			Element root1 = doc1.getRootElement();
			
			/*Element b = root1.element("b");
			//user.setText("111111111111111");
			//Element userInfo = root.element("userInfo");
			Element team = root.element("team");
			team.add(b);*/
			//将aaa的根节点加到sss中，即doc1加到doc中
			root1.setName("SBBBBBB");
			root.add(root1);
			HandleXML hx = new HandleXML();
			hx.writeDoc("E:\\TEST\\sss.xml", doc);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
