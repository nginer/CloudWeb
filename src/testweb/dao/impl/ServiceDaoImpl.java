package testweb.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;









import java.util.UUID;

import javax.print.DocFlavor.STRING;

import com.mysql.jdbc.PreparedStatement;

import sun.print.resources.serviceui;
import testweb.dao.ServiceDao;
import testweb.mysql.DBConnection;
import testweb.vo.*;
public class ServiceDaoImpl implements ServiceDao{

	@Override
	/**
	 * author 小白
	 * time 2015/6/1
	 */
	public Service getServiceByID(String id) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		String sql ="SELECT service_ID from service where service_ID='"+id+"'";
		Service service = new Service();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				service.setData_ID(resultSet.getString("data_ID"));
				service.setData_name(resultSet.getString("data_name"));
				service.setOwner_ID(resultSet.getString("owner_ID"));
				service.setOwner_name(resultSet.getString("owner_name"));
				service.setProcessType(resultSet.getString("processType"));
				service.setProgram_ID(resultSet.getString("program_ID"));
				service.setProgram_name(resultSet.getString("program_name"));
				service.setService_describe(resultSet.getString("service_describe"));
				service.setService_ID(resultSet.getString("service_ID"));
				service.setService_keywords(resultSet.getString("service_keywords"));
				service.setService_name(resultSet.getString("service_name"));
				service.setStatus(resultSet.getString("status"));
				service.setTime_construct(resultSet.getString("time_construct"));
				service.setUrl(resultSet.getString("url"));
				service.setDomain(resultSet.getString("domain"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service;
	}

	@Override
	//向数据库service表中添加一条服务信息
	public boolean addService(Service service) {
		// TODO Auto-generated method stub
		String service_ID = service.getService_ID();
		String service_name = service.getService_name();
		String service_keywords = service.getService_keywords();
		String service_describe = service.getService_describe();
		String owner_ID = service.getOwner_ID();
		String owner_name = service.getOwner_name();
		String data_ID = service.getData_ID();
		String data_name = service.getData_name();
		String program_ID = service.getProgram_ID();
		String program_name = service.getProgram_name();
		String status = service.getStatus();
		String processType = service.getProcessType();
		String time_construct = service.getTime_construct();
		String url = service.getUrl();
		String domain = service.getDomain();
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "insert into service(service_ID,service_name,service_keywords,service_describe,owner_ID,owner_name,data_ID,data_name,program_ID,program_name,status,processType,time_construct,url,domain) values('"+service_ID+"','"+service_name+"','"+service_keywords+"','"+service_describe+"','"+owner_ID+"','"+owner_name+"','"+data_ID+"','"+data_name+"','"+program_ID+"','"+program_name+"','"+status+"','"+processType+"','"+time_construct+"','"+url+"','"+domain+"');";
		int row = 0;
		try {
			Statement sta = con.createStatement();
			row=sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作错误！");
		}
		if(row>0){
			System.out.println("成功修改了"+row+"行！！！");
			return true;
		}else
		return false;
	}

	@Override//小白
	public boolean deleteService(String id) {
		// TODO Auto-generated method stub
		//PreparedStatement ps = null;
		int row = 0;
		//boolean b = false;
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="delete from service where service_ID ='"+id+"'";
		try {
			Statement stmt = con.createStatement();
			 row =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row >0){
			System.out.println("成功删除了ID为"+id+"的一条记录");
			return true;
		}else
			return false;
		
	}

	@Override
	public List<Service> getAllService() {
		// TODO Auto-generated method stub
		List<Service> list = new ArrayList<Service>();
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="select * from service";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){
				Service service = new Service();
				service.setData_ID(rs.getString("data_ID"));
				service.setData_name(rs.getString("data_name"));
				service.setOwner_ID(rs.getString("owner_ID"));
				service.setOwner_name(rs.getString("owner_name"));
				service.setProgram_ID(rs.getString("program_ID"));
				service.setProgram_name(rs.getString("program_name"));
				service.setService_describe(rs.getString("service_describe"));
				service.setService_ID(rs.getString("service_ID"));
				service.setService_keywords(rs.getString("service_keywords"));
				service.setService_name(rs.getString("service_name"));
				service.setStatus(rs.getString("status"));
				service.setProcessType(rs.getString("processType"));
				service.setTime_construct(rs.getString("time_construct"));
				service.setUrl(rs.getString("url"));
				service.setDomain(rs.getString("domain"));
				list.add(service);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Service> getServicesByOwnerID(String ownerID) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM service WHERE owner_ID ='"+ownerID+"'";
		//System.out.println(sql);
		Statement st;
		List<Service> list = new ArrayList<Service>();
		
			try {
				
				Service service = new Service();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				//ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()){
					service.setData_ID(rs.getString("data_ID"));
					service.setData_name(rs.getString("data_name"));
					service.setOwner_ID(rs.getString("owner_ID"));
					service.setOwner_name(rs.getString("owner_name"));
					service.setProgram_ID(rs.getString("program_ID"));
					service.setProgram_name(rs.getString("program_name"));
					service.setService_describe(rs.getString("service_describe"));
					service.setService_ID(rs.getString("service_ID"));
					service.setService_keywords(rs.getString("service_keywords"));
					service.setService_name(rs.getString("service_name"));
					service.setStatus(rs.getString("status"));
					service.setProcessType(rs.getString("processType"));
					service.setTime_construct(rs.getString("time_construct"));
					service.setUrl(rs.getString("url"));
					service.setDomain(rs.getString("domain"));
					list.add(service);
				}
				DBConnection.getInstance().close(rs, st, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	@Override
	//生成一个服务的ID
	public String createServiceID() {
		// TODO Auto-generated method stub
		UUID serviceUUID = UUID.randomUUID();
		String serviceID = "service:"+serviceUUID.toString();
		return serviceID;
	}

	@Override
	public List<Service> getServiceByDomain(String domain) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "select * from service where domain='"+domain+"'";
		Statement sta;
		List<Service> list = new ArrayList<Service>();
		ResultSet rs;
		Service service = new Service();
		try {
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				service.setData_ID(rs.getString("data_ID"));
				service.setData_name(rs.getString("data_name"));
				service.setOwner_ID(rs.getString("owner_ID"));
				service.setOwner_name(rs.getString("owner_name"));
				service.setProgram_ID(rs.getString("program_ID"));
				service.setProgram_name(rs.getString("program_name"));
				service.setService_describe(rs.getString("service_describe"));
				service.setService_ID(rs.getString("service_ID"));
				service.setService_keywords(rs.getString("service_keywords"));
				service.setService_name(rs.getString("service_name"));
				service.setStatus(rs.getString("status"));
				service.setProcessType(rs.getString("processType"));
				service.setTime_construct(rs.getString("time_construct"));
				service.setUrl(rs.getString("url"));
				service.setDomain(rs.getString("domain"));
				list.add(service);
			}
			DBConnection.getInstance().close(rs, sta, con);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return list;
	}
		
}
