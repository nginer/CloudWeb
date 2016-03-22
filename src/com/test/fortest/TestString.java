package com.test.fortest;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="<?xml version='1.0' encoding='UTF-8'?><tableStructure><tableName>最好</tableName><dataList><data><rowKey>testRowKey</rowKey><familyList><family name='43她如3'><qualifier name='哥哥让人'><value></value></qualifier><qualifier name='瑞特人'><value></value></qualifier><qualifier name='个人股'><value></value></qualifier></family><family name='计算机'><qualifier name='内村'><value></value></qualifier></family></familyList></data></dataList></tableStructure>";
		int index0 = a.indexOf("<");
		int index = a.indexOf("<", 2);
		String b = a.substring(38);
		System.out.println("!!!!"+b);
		System.out.println(index0);
		System.out.println(index);
		
		/*System.out.println(a);
		String b = a.replaceAll("\"","'" );
		System.out.println(b);*/
		
	}

}
