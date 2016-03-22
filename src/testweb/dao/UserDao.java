package testweb.dao;

import java.util.List;

import testweb.vo.*;

public interface UserDao {
	//生成一个用户ID，格式：‘user’+UUID
	public String createUserID();
	//根据ID获取用户信息
	public User getUserByID(String id);
	//添加一个用户信息
	public boolean addUser(User user);
	//删除一个用户信息
	public boolean deleteUser(String id);
	//获得所有用户信息
	public List<User> getAllUser();
	//返回数据个数
	public int getCount();
		
	//黄紫微  2015,4,1根据name获取用户信息
	public User getUserByName(String user_name);
	
	//黄紫微 2015,4,7 找数据库中是否有username找不到返回ture
	boolean SearchUsername(String username);
	
	//黄紫微 2015,4,7 找数据库中是否有email找不到返回ture
	boolean SearchEmail(String email);
	
	boolean UpdateUser(User user);
	//////////
	
	

}