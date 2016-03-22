package testweb.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://10.10.167.144:3306/webservice";
		String user="webservice";
		String password = "1234asdf";
		try {
			 Class.forName("com.mysql.jdbc.Driver") ;   
			Connection con = DriverManager.getConnection(url, user, password);
			if(!con.isClosed()){
				System.out.println("---连上了---");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("---class.forname---");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---connection---");
		}
		
		
		
	}

}
