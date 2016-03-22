package com.test.file_operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandleFile hf = new HandleFile();
		hf.createFile("E://TEST","describe.xml");
		String path = "E://TEST//describe.xml";
		/*SAXReader reader = new SAXReader();
		try {
			//FileInputStream in = new FileInputStream(new File(path));
			//Document doc= reader.read(in);
			Document doc= reader.read(new File(path));
			Element ele = doc.getRootElement();
			System.out.println(ele+"这里是输出！！！");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建sax读取出错！！！");
		}
		
	}*/
		HandleXML hx = new HandleXML();
		hx.writeRoot2XML(path, "servicesss");
		

}
}
