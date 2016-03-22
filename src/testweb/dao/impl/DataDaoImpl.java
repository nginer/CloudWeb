package testweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sun.xml.internal.stream.StaxXMLInputSource;

import testweb.dao.DataDao;
import testweb.mysql.DBConnection;
import testweb.vo.Data;

public class DataDaoImpl implements DataDao{
/**
 * author 小白
 * time 2015/6/1
 */
	@Override
	public Data getDatabyID(String id) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "select data_ID from data where data_ID='"+id+"'";
		
		Data data = new Data();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				
				data.setData_describe(resultSet.getString("data_describe"));
				data.setData_ID(resultSet.getString("data_ID"));
				data.setData_name(resultSet.getString("data_name"));
				data.setOwner_ID(resultSet.getString("owner_ID"));
				data.setService_ID(resultSet.getString("service_ID"));
				data.setTime_lastModify(resultSet.getString("time_lastModify"));
				data.setTime_upload(resultSet.getString("time_upload"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public boolean addData(Data data) {
				String data_ID = data.getData_ID();
				String data_name = data.getData_name();
				String data_describe = data.getData_describe();
				String owner_ID = data.getOwner_ID();	
				String time_upload = data.getTime_upload();				
				String service_ID = data.getService_ID();
				String time_lastModify = data.getTime_lastModify();
			
				Connection con = DBConnection.getInstance().getConnection();
				String sql = "insert into data(data_ID,data_name,data_describe,owner_ID,time_upload,service_ID,time_lastModify) values('"+data_ID+"','"+data_name+"','"+data_describe+"','"+owner_ID+"','"+time_upload+"','"+service_ID+"','"+time_lastModify+"');";
				System.out.println("语句！！！"+sql);
				//String sql = "insert into data(data_ID,data_name,data_describe,owner_ID,time_upload,service_ID,time_lastModify) values('555555555555','111','111','888','555','66','777');";
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

	@Override
	public boolean deleteData(String id) {
		int row = 0;
		// TODO Auto-generated method stub
		Connection con =DBConnection.getInstance().getConnection();
		String sql ="delete from data where data_ID='"+id+"'";
		try {
			Statement stmt = con.createStatement();
			row =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(row>0){
			System.out.println("成功删除了ID为"+id+"的一条记录");
		return true;
		}else 
			return false;
	}

	@Override
	public List<Data> getAllData() {
		// TODO Auto-generated method stub
		List<Data> list = new ArrayList<Data>();
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="select * from data";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){
				Data data = new Data();
				data.setData_ID(rs.getString("data_ID"));
				data.setData_name(rs.getString("data_name"));
				data.setData_describe(rs.getString("data_descrbe"));
				data.setTime_lastModify(rs.getString("time_upload"));
				data.setTime_lastModify(rs.getString("time_lastModify"));
				data.setTime_lastModify(rs.getString("time_lastModify"));
				data.setOwner_ID(rs.getString("owner_ID"));
				data.setService_ID(rs.getString("service_ID"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Data> getDataByOwnerID(String ownerid) {
		// TODO Auto-generated method stub
		List<Data> list = new ArrayList<Data>();
		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "SELECT* FROM data WHERE owner_ID='"+ownerid+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Data data = new Data();
				data.setData_ID(rs.getString("data_ID"));
				data.setData_name(rs.getString("data_name"));
				//坑爹啊！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
				//data.setData_describe(rs.getString("data_descrbe"));
				data.setData_describe(rs.getString("data_describe"));
				data.setTime_lastModify(rs.getString("time_upload"));
				data.setTime_lastModify(rs.getString("time_lastModify"));
				data.setOwner_ID(rs.getString("owner_ID"));
				data.setService_ID(rs.getString("service_ID"));
				list.add(data);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String createDataID() {
		// TODO Auto-generated method stub
		UUID dataUUID = UUID.randomUUID();
		String dataID = "data:"+dataUUID.toString();
		return dataID;
	}

}
