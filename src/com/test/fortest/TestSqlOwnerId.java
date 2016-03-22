package com.test.fortest;

import testweb.dao.impl.ServiceDaoImpl;

public class TestSqlOwnerId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceDaoImpl impl = new ServiceDaoImpl();
		impl.getServicesByOwnerID("13052032");

	}

}
