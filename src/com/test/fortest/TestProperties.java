package com.test.fortest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import testweb.controller.construction.createServiceController;

public class TestProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pro = new Properties();
		pro.setProperty("rrrrrrrrrrr", "kaokaokao");
		//File file = new File("66.properties");
		try {
			System.out.println("*********************");
			FileOutputStream output = new FileOutputStream("/56.properties");
			//System.out.println(output.equals(null));
			pro.store(output, "hhahah ");
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fileoutstream出错！！！");
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("store出错！~！！");
			e.printStackTrace();
		}
		InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("test.properties");
		try {
			pro.load(in);
			String aa = pro.getProperty("ttt");
			System.out.println(aa+"**********************");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("load******************");
			e.printStackTrace();
		}
	}

}
