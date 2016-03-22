package testweb.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import testweb.dao.UserDao;
import testweb.mysql.DBConnection;
import testweb.vo.User;

public class UserDaoImpl implements UserDao{
	/**
	 * user表的操作
	 */
	@Override
	//根据输入ID返回一个User对象，在对象中有具体的属性操作获得相应的值，如getUser_ID()，getTime_regist()等。
	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM user WHERE user_ID ='"+id+"'";
		System.out.println(sql);
		User user = new User();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();
			//这一块可以写成ArrayList<hashmap>的形式，把每一行列名和列值对应，如下
			/*ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			try {
				while (set.next()) {
					HashMap<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < meta.getColumnCount(); i++) {

						map.put(meta.getColumnName(i + 1).toUpperCase(),
								set.getString(meta.getColumnName(i + 1)));

					}
					list.add(map);
				}*/
			//for(int i=1;i<rsmd.getColumnCount();i++){
				user.setEmail(rs.getString("email"));
				user.setGroup(rs.getString("gro"));
				//需要改，密码不可以显示
				user.setPassword(rs.getString("password"));
				user.setTime_login(rs.getString("time_regist"));
				user.setTime_login(rs.getString("time_login"));
				user.setUser_ID(rs.getString("user_ID"));
				user.setUser_name(rs.getString("user_name"));
				user.setTel(rs.getString("tel"));
				//System.out.println(i+"----"+rsmd.getColumnCount());
				
			//}
			DBConnection.getInstance().close(rs, st, con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createstatement");
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	//首先实例化一个user对象，然后通过其中set方法将具体的值赋给对象的具体属性。
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		Statement st;
		int row = 0;
		try {
			st = con.createStatement();
			 String sql = "INSERT INTO user(user_ID,user_name,time_regist,time_login,email,password,gro,tel)values('"+user.getUser_ID()+"','"+user.getUser_name()+"','"+user.getTime_regist()+"','"+user.getTime_login()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGroup()+"','"+user.getTel()+"')";
			  row= st.executeUpdate(sql);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建statement");
		}
		if(row>0){
			System.out.println("修改了"+row+"条数据！！");
			return true;
		}else{
			System.out.println("row这里报错了");
		return false;}
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from user";
		Connection con = DBConnection.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		try {
			st=con.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			System.out.println("结果的count的大小！！！"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
//黄紫微  添加  2015、4、1
	@Override
	//根据输入ID返回一个User对象，在对象中有具体的属性操作获得相应的值，如getUser_ID()，getTime_regist()等。
	public User getUserByName(String name) {   
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM user WHERE user_name ='"+name+"'";
		System.out.println(sql);
		User user = new User();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();
			//这一块可以写成ArrayList<hashmap>的形式，把每一行列名和列值对应，如下
			/*ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			try {
				while (set.next()) {
					HashMap<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < meta.getColumnCount(); i++) {

						map.put(meta.getColumnName(i + 1).toUpperCase(),
								set.getString(meta.getColumnName(i + 1)));

					}3
					list.add(map);
				}*/
			//for(int i=1;i<rsmd.getColumnCount();i++){
				user.setEmail(rs.getString("email"));
				user.setGroup(rs.getString("gro"));
				//需要改，密码不可以显示
				user.setPassword(rs.getString("password"));
				user.setTime_login(rs.getString("time_regist"));
				user.setTime_login(rs.getString("time_login"));
				user.setUser_ID(rs.getString("user_ID"));
				user.setUser_name(rs.getString("user_name"));
				//System.out.println(i+"----"+rsmd.getColumnCount());
				
			//}
			DBConnection.getInstance().close(rs, st, con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createstatement");
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	//2015.4.8 黄紫微 查找数据库中是否有用户名username
	@Override
	public boolean SearchUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select count(user_name) from user where user_name='"+username+"'";
		Connection con = DBConnection.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		try {
			st=con.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			System.out.println("结果的count的大小！！！"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count == 0){
			System.out.println("user表包含了"+count+"条"+username);
			return true;
		}else{
			System.out.println("！！！user表包含了"+count+"条"+username);
		return false;}
	}
	
	//2015.4.8 黄紫微 查找数据库中是否有邮箱email
	@Override
	public boolean SearchEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select count(user_name) from user where user_name='"+email+"'";
		Connection con = DBConnection.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		try {
			st=con.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			System.out.println("结果的count的大小！！！"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count == 0){
			System.out.println("email  user表包含了"+count+"条"+email);
			return true;
		}else{
			System.out.println("email   ！！！user表包含了"+count+"条"+email);
		return false;}
	}
//
	//修改部分属性 ： 邮箱  密码  电话号码
	public boolean UpdateUser(User user) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		Statement st;
		int row = 0;

		try {
			st = con.createStatement();
			 String sql = "UPDATE user set email='"+user.getEmail()+"',password='"+user.getPassword()+"',tel='"+user.getTel()+"'where user_name ='"+user.getUser_name()+"'";
			 row= st.executeUpdate(sql);
			  System.out.println("888888888");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建statement");
			System.out.println("lllllllllll");
		}
		if(row>0){
			System.out.println("修改了"+row+"条数据！！");
			return true;
		}else{
			System.out.println("row这里报错了");
		return false;}
	}

	@Override
	public String createUserID() {
		// TODO Auto-generated method stub
		UUID userUUID = UUID.randomUUID();
		String userID = "user:"+userUUID.toString();
		return userID;
	}


}