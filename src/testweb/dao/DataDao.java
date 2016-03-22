package testweb.dao;

import java.util.List;

import testweb.vo.*;

public interface DataDao {
		//生成一个上传数据ID，格式：‘data’+UUID
		public String createDataID();
		//根据ID获取数据信息
		public Data getDatabyID(String id);
		//添加一个数据信息
		public boolean addData(Data data);
		//删除一个数据信息
		public boolean deleteData(String id);
		//获得所有数据信息
		public List<Data> getAllData();
		public List<Data> getDataByOwnerID(String ownerid);

}
