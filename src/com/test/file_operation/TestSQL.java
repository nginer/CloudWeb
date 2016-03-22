package com.test.file_operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import testweb.dao.impl.UserDaoImpl;
import testweb.mysql.DBConnection;
import testweb.vo.User;

public class TestSQL {
	
	
	
	////

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * UserDaoImpl udi =new UserDaoImpl(); User user =
		 * udi.getUserByID("2015032201");
		 * 
		 * System.out.println(user);
		 */
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM user WHERE USER_ID ='" + 2015032201 + "'";
		System.out.println(sql);
		User user = new User();
		user.equals(null);

		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
		
			System.out.println(rsmd.getColumnCount() + "看这里！！！！！！！！！！");
			rs.next();
			System.out.println(rs.getString("user_ID")+"HHHHHHHHHHHHH");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
