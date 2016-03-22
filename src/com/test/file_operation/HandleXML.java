package com.test.file_operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class HandleXML {
	// xml写入，xml读出
	// 写入根节点
	/*OutputFormat format = new OutputFormat(" ", true, "utf-8");*/
		public void writeRoot2XML(String XMLpath, String rootNode) {
			//不出意外。这个方法只在创建xml文件的时候调用一次。之后不再调用，否则xml文件中内容会被冲掉!!!
			Element rootElement = DocumentHelper.createElement(rootNode);
			Document doc = DocumentHelper.createDocument(rootElement);
			writeDoc(XMLpath, doc);
			/*try {
				XMLWriter writer = new XMLWriter(new FileWriter(XMLpath), format);
				writer.write(doc);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		/*
		 * 写入父节点 或者 在父节点fathernode下创建子节点
		 */
		// arraylist的参数可为string（加入根节点下父节点）或者hashmap（加入子节点）
		// 如果al元素为string，则参数fathernode应该为root，则是插入root下父节点。参数fathernode可以为“”
		// 否则，应该在fathernode中添加子节点
	public void write2XML(String XMLpath, String fatherNode, ArrayList al) throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		Element root = null;
		Document doc = null;
		doc = reader.read(new File(XMLpath));
		root = doc.getRootElement();
		System.out.println(root+"1111111111111111111");
		Iterator it = al.iterator();
		if(al.get(0).getClass().getName()=="java.lang.String"){
			//如果为string的list，则只是插入节点，里面没有写入值。
		while(it.hasNext()){
			String elem_nx = it.next().toString();
			System.out.println(elem_nx+"!!!!!!!!!!!!");
			root.addElement(elem_nx);
			
		}
		}else{
			//如果是map类型的话，即arraylist中存储hashmap型的元素，则即插入节点，也为节点赋值。
			//
			Element elem_fa = root.element(fatherNode);
			System.out.println(elem_fa+"2222222222222222");
			String key = null ;
			String value = null ;
			Map.Entry entry = null;
			while(it.hasNext()){
				//String childName = it.next()
				HashMap  hm = (HashMap) it.next();
				Iterator itMap = hm.entrySet().iterator();
				while(itMap.hasNext()){
					Map.Entry et = (Entry) itMap.next();
					String k = (String) et.getKey();
					String v = (String) et.getValue();
					Element elem_child = elem_fa.addElement(k);
					elem_child.setText(v);
				}
				
			}
		}
	/*	XMLWriter writer = new XMLWriter(new FileWriter(XMLpath),format);
		writer.write(doc);
		writer.flush();
		writer.close();*/
		writeDoc(XMLpath, doc);
		
	}
	//重载一个函数
	public void write2XML(String path,String father,Element ele){
		
	}
	//返回xml文件的root节点
	public Element getRoot(String path){
		SAXReader reader = new SAXReader();
		Document doc = null ;
		Element root = null ;
		try {
			doc = reader.read(new File(path));
			root = doc.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("获取根节点出错~~~~~~~~~~~~~");
			e.printStackTrace();
			
		}
		return root;
		
	}
	//返回xml文件的document对象
	public Document getDocument(String path){
		SAXReader reader = new SAXReader();
		Document doc = null ;
		try {
			doc = reader.read(new File(path));
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
		
	}
	//将修改后xml的doc写入到文件当中
	public void writeDoc(String path,Document doc){
		OutputFormat format = new OutputFormat("", true, "utf-8");
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(path), format);
			writer.write(doc);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("！！！调用writeDoc方法的时候出错");
		}
	}
	//用于将字符串转换为ArrayList<HashMap<String,String>>()类型
	//以后需要提前把接口写好，不能像下面那样，把接口定义清楚！！！！！
	public void toAL_HM(){
		
	}
	//用于将字符串转换为ArrayList<String>()类型
	public void toAL(){
		
	}
	//判断某节点“xxx”下是否已经有元素，如果有则返回false，如果没有则返回ture表示可插入。
	public boolean haveChild(Element element){
		
		return true;
	}
	//删除某节点下的所有子节点，但是不能删除根节点。
	public void DeleteChild(String path,Element FatherElement){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			 doc = reader.read(new File(path));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Element> list = FatherElement.elements();
		Iterator<Element> it= list.iterator();
		Element ele = null ;
		while(it.hasNext()){
			ele = it.next();
			ele.getParent().remove(ele);
		}
		writeDoc(path, doc);
	}
	public void DeleteChild(String path,String fatherName){
		SAXReader reader = new SAXReader();
		Document doc = null;
		Element root = null ;
		Element fatherElem = null;
		try {
			 doc = reader.read(new File(path));
			 root = doc.getRootElement();
			// fatherElem = root.element(fatherName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("删除fathernode下的所有节点，在deletechild这里出错！！！");
			e.printStackTrace();
		}
		fatherElem = root.element(fatherName);
		
		if(fatherElem==null) {
			System.out.println("deletechild函数这里，father节点为空！！！");
			return;}
		List<Element> list = fatherElem.elements();
		Iterator<Element> it= list.iterator();
		Element ele = null ;
		while(it.hasNext()){
			ele = it.next();
			ele.getParent().remove(ele);
		}
		writeDoc(path, doc);
	}
	//删除fathernode和所有子节点，包括fathernode哟
	public void DeleteAll(String path,String fatherName){
		SAXReader reader = new SAXReader();
		Document doc = null;
		Element root = null ;
		Element fatherElem = null;
		try {
			 doc = reader.read(new File(path));
			 root = doc.getRootElement();
			// fatherElem = root.element(fatherName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("删除fathernode下的所有节点，在deletechild这里出错！！！");
			e.printStackTrace();
		}
		fatherElem = root.element(fatherName);
		
		if(fatherElem==null) {
			System.out.println("deletechild函数这里，father节点为空！！！");
			return;}
		List<Element> list = fatherElem.elements();
		Iterator<Element> it= list.iterator();
		Element ele = null ;
		while(it.hasNext()){
			ele = it.next();
			ele.getParent().remove(ele);
		}
		fatherElem.getParent().remove(fatherElem);
		writeDoc(path, doc);
	}
	//这里完成：映射关系的xml写入，将映射关系转化为string  xml字符串返回，进行后续的AJAX传递。
	public String crazy(){
		
		
		return null;
	}
	
}
