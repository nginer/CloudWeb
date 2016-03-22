package testweb.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//数据库的单例连接
public class DBConnection {
	private static DBConnection instance;
	private String url;
	private String username;
	private String password;
	private DBConnection(){
		Properties ps = new Properties();
		InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			ps.load(is);
			url = ps.getProperty("url");
			username = ps.getProperty("username");
			password = ps.getProperty("password");
			System.out.println("!!!!!!"+url+username+password+"????????");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DBConnection getInstance(){
		synchronized (instance){
			if (instance==null){
				return new DBConnection();
			}else
				return instance ;
			
			
		}
	}
	static{
		instance = new DBConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	//关闭打开的记录集、声明、连接对象
	public void close(ResultSet rs,Statement st,Connection con) throws SQLException{
		
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(con!=null){
			con.close();
		}
	}
	public void close(Statement st,Connection con) throws SQLException{
		if(st!=null){
			st.close();
		}
		if(con!=null){
			con.close();
		}
	}
	public void close(ResultSet rs,PreparedStatement pst,Connection con) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(con!=null){
			con.close();
		}
	}
	//
	public static void main(String[] args){
		System.out.println("连接状况如下所示！！！！！！！！！");
		System.out.println(DBConnection.getInstance().getConnection());
	}

}

