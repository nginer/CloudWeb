package com.test.file_operation;

import testweb.dao.impl.UserDaoImpl;
import testweb.vo.User;

public class TestUserImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImpl impl = new UserDaoImpl();
		User user = new User();
		user.setEmail("1111");
		user.setGroup("admin");
		user.setPassword("88888888888");
		user.setTel("999999999999");
		user.setTime_login("1995");
		user.setTime_regist("1996");
		user.setUser_ID("131415926");
		user.setUser_name("SSSSSSSSSSSS");
		impl.addUser(user);
		
	}

}
