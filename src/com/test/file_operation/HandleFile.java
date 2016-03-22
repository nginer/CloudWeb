package com.test.file_operation;
import java.io.*;
import java.util.ArrayList;

import org.dom4j.DocumentException;

public class HandleFile {
	//创建文件夹和文件，功能分开，易复用。
	//如果filename=0,则只创建文件夹
	/**
	如果文件所在的文件夹不存在则先创建文件夹，不过，也可以用createFolder函数只创建文件夹
	 */
	public File createFile(String foldername,String filename){
		
		File folder = new File(foldername);
		File file = new File(foldername+"//"+filename);
		String fullPath = foldername+"//"+filename;
		if(folder.exists()==false){
			folder.mkdirs();
			System.out.println("创建folder文件夹"+foldername+"成功！！！");
		}else{
			System.out.println(folder+"已存在！！！");
		}
		//如果文件存在就不会再次写入root节点。
		if(file.exists()==false){
			try {
				file.createNewFile();
				System.out.println("创建file文件"+file+"成功！！！");
				if(filename=="service.xml"){
					//如果是这个xml，则直接将各个主要节点写入。
					HandleXML hx = new HandleXML();
					//根节点
					hx.writeRoot2XML(fullPath, "service");
					ArrayList< String> al = new ArrayList<String>();
					al.add("userInfo");
					al.add("serviceID");
					al.add("describe");
					//al.add("tableStructure");
					//al.add("reflect");
					hx.write2XML(fullPath, "", al);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				System.out.println("在根节点下挂载子节点的时候出错！！就是挂载服务的描述、映射那些的时候");
				e.printStackTrace();
			}
		}else{
			System.out.println(file+"已存在！！！");
		}
		return file;
		
	}
	//作为上面createfile方法的扩展，在系统完成后，会保留这个函数createFile1，将上面的 createfile去掉
public File createFile1(String foldername,String filename){
		
		File folder = new File(foldername);
		File file = new File(foldername+"//"+filename);
		String fullPath = foldername+"//"+filename;
		if(folder.exists()==false){
			folder.mkdirs();
			System.out.println("创建文件夹folder"+foldername+"成功！！！");
		}else{
			System.out.println(folder+"已存在！！！");
		}
		//如果文件存在就不会再次写入root节点。
		if(file.exists()==false){
			try {
				file.createNewFile();
				System.out.println("创建文件file"+file+"成功！！！");
				/*System.out.println("~~~~~~~~~~~~~~~~~");
				System.out.println(filename.substring(filename.length()-3)+"\n"+foldername.substring(foldername.length()-7));
				System.out.println("~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1"+filename.substring(filename.length()-3).equals("xml"));
				System.out.println("2"+foldername.substring(foldername.length()-7).equals("service"));
				System.out.println(filename.substring(filename.length()-3).equals("xml")&&foldername.substring(foldername.length()-7).equals("service"));*/
				if(filename.substring(filename.length()-3).equals("xml")&&foldername.substring(foldername.length()-7).equals("service")){
					//如果是用户service文件夹下的xml文件，那么就一定是***.xml的服务xml文件，直接将各个主要节点写入。
					System.out.println("要创建节点啦啦啦啦啦啦啦啦！！！！！！！！");
					HandleXML hx = new HandleXML();
					//根节点
					hx.writeRoot2XML(fullPath, "service");
					ArrayList< String> al = new ArrayList<String>();
					al.add("userInfo");
					al.add("serviceID");
					al.add("describe");
					//al.add("tableStructure");
					//al.add("reflect");
					hx.write2XML(fullPath, "", al);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				System.out.println("在根节点下挂载子节点的时候出错！！就是挂载服务的描述、映射那些的时候");
				e.printStackTrace();
			}
		}else{
			System.out.println(file+"已存在！！！");
		}
		return file;
		
	}
	//创建文件夹
		public void createFolder(String path){
			File folder = new File(path);
			if(folder.exists()==false){
			folder.mkdirs();
			System.out.println("创建文件夹"+path+"\n");
			}
		}
		//递归删除
		public void deleteFile(String path){
			File file =new File(path);
			 if (file.isDirectory()) {   
			      File[] ff = file.listFiles();   
				       for (int i = 0; i < ff.length; i++) {   
				          deleteFile(ff[i].getPath());   
				       }   
				    }   
				   file.delete();  
		}
		

}
