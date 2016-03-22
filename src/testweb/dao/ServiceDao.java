package testweb.dao;

import java.util.List;

import testweb.vo.*;

public interface ServiceDao {
	//生成一个服务ID，格式：‘service’+UUID
	public String createServiceID();
	//根据ID获取服务信息
	public Service getServiceByID(String id);
	//添加一个服务信息
	public boolean addService(Service service);
	//删除一个服务信息
	public boolean deleteService(String id);
	//获得所有服务信息
	public List<Service> getAllService();
	//根据用户ID获得用户的所有的服务
	public List<Service> getServicesByOwnerID(String ownerID);
	//根据domain获取服务集合
	public List<Service> getServiceByDomain(String domain);
	


}
