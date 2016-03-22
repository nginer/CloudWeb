package testweb.dao;

import java.util.List;

import testweb.vo.*;

public interface ProgramDao {
		////生成一个程序ID，格式：‘program:’+UUID
		public String createProgramID();
		//根据ID获取程序信息
		public Program getProgrambyID(String id);
		//添加一个程序信息
		public boolean addProgram(Program program);
		//删除一个程序信息
		public boolean deleteProgram(String id);
		//获得所有程序信息
		public List<Program> getAllProgram();
		public List<Program> getProgramByOwnerID(String ownerid );

}
