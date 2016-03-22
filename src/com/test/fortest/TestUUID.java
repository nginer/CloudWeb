package com.test.fortest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.hadoop.hdfs.server.namenode.FileChecksumServlets.GetServlet;

import testweb.controller.construction.createServiceController;
import testweb.vo.User;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;
import com.test.file_operation.HandleFile;
import com.test.file_operation.HandleXML;

public class TestUUID {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		String u = uuid.toString();
		System.out.println("uuid~~~"+u);
		System.out.println("uuid的长度~~~"+u.length());
		System.out.println("加前缀之后的长度~~~"+("program:"+u).length());
		HandleFile hf = new HandleFile();
		hf.createFile1("H://1111111111/service","1.xml");
		
		hf.createFile1("H:/2222222222//serviceee","12.xml");
		
		hf.createFile1("H://333333333333\\service","2.xml");
		hf.createFile1("H:\\444444444444444//service","3.xml");
		
		System.out.println(u+".xml");
		System.out.println(u+"/.xml");
		User user = new User();
		
		
		/*Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream("66.properties");
		ps.load(in);
		String Str = ps.getProperty("dog");
		System.out.println(Str+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^");*/
		//System.out.println("\n%%%%%%%%%%%%%%%%%"+user.getClass().getClassLoader().getResource("/").getPath().toString());
		String p = user.getClass().getClassLoader().getResource("").getPath().toString();
		System.out.println("***************"+p);
		String pdo = p.substring(1,p.length()-15);
		System.out.println("*************"+pdo);
		Properties properties = new Properties();
        properties.setProperty("ttt", "liuliu");
        OutputStream output = new FileOutputStream("66.properties");
        properties.store(output,"tkkkkkkkkk");
        output.close();
        System.out.println("//haiyou\\");


	}

}
