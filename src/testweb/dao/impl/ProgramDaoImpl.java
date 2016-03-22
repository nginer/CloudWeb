package testweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import testweb.dao.*;
import testweb.mysql.DBConnection;
import testweb.vo.Program;
import testweb.vo.Service;

public class ProgramDaoImpl implements ProgramDao{

	@Override
	/**
	 * author 小白
	 * time 2015/6/1
	 */
	public Program getProgrambyID(String id) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		String sql = "SELECT program_ID FROM program WHERE program_ID='"+id+"'";
		Program program = new Program();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				program.setOwner_ID(resultSet.getString("owner_ID"));
				program.setProgram_describe(resultSet.getString("program_describe"));
				program.setProgram_ID(resultSet.getString("program_ID"));
				program.setProgram_name(resultSet.getString("program_name"));
				program.setService_ID(resultSet.getString("service_ID"));
				program.setTime_upload(resultSet.getString("time_upload"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return program;
	}

	@Override
	public boolean addProgram(Program program) {
		// TODO Auto-generated method stub
		String program_ID = program.getProgram_ID();
		String program_name = program.getProgram_name();
		String program_describe = program.getProgram_describe();
		String owner_ID = program.getOwner_ID();	
		String time_upload = program.getTime_upload();				
		String service_ID = program.getService_ID();
		//String time_lastModify = program.getTime_lastModify();
	
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "insert into program(program_ID,program_name,program_describe,time_upload,owner_ID,service_ID) values('"+program_ID+"','"+program_name+"','"+program_describe+"','"+time_upload+"','"+owner_ID+"','"+service_ID+"');";
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
	public boolean deleteProgram(String id) {
		// TODO Auto-generated method stub
		int row = 0;
		//boolean b = false;
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="delete from program where program_ID ='"+id+"'";
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
	public List<Program> getAllProgram() {
		// TODO Auto-generated method stub
		List<Program> list = new ArrayList<Program>();
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="select * from program";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){
				Program program = new Program();
				program.setProgram_ID(rs.getString("program_ID"));
				program.setProgram_name(rs.getString("program_name"));
				program.setProgram_describe(rs.getString("program_describe"));
				program.setTime_upload(rs.getString("time_upload"));
				program.setOwner_ID(rs.getString("owner_ID"));
				program .setService_ID(rs.getString("service_ID"));
				list.add(program);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Program> getProgramByOwnerID(String ownerid) {
		// TODO Auto-generated method stub
		List<Program > list = new ArrayList<Program>();
		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "SELECT* FROM program WHERE owner_ID='"+ownerid+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Program program = new Program();
				program.setProgram_ID(rs.getString("program_ID"));
				program.setProgram_name(rs.getString("program_name"));
				program.setProgram_describe(rs.getString("program_describe"));
				program.setTime_upload(rs.getString("time_upload"));
				program.setOwner_ID(rs.getString("owner_ID"));
				program .setService_ID(rs.getString("service_ID"));
				list.add(program);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String createProgramID() {
		// TODO Auto-generated method stub
		UUID programUUID = UUID.randomUUID();
		String programID = "program:"+programUUID.toString();
		return programID;
	}
	

}
