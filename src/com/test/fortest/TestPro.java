package com.test.fortest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import testweb.controller.construction.createServiceController;

public class TestPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String proPath = "service.properties";
		Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = ps.getProperty("path");
		System.out.println(path);

	}

}
