/**
 * 
 */
package testweb.dao;


import java.util.List;

import testweb.vo.Admin;

/**
 * @author Harry
 *
 */
public interface AdminDao {
	//根据ID获取管理员信息
	public Admin getAdminbyID(String id);
	//添加一个管理员信息
	public boolean addAdmin(Admin admin);
	//删除一个管理员信息
	public boolean deleteAdmin(String id);
	//获得所有管理员信息
	public List<Admin> getAllAdmin();
	

	
}
