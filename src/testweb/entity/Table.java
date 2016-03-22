package testweb.entity;

import java.util.ArrayList;
import java.util.List;

import testweb.vo.Data;
import testweb.vo.Program;
import testweb.vo.Service;
//table类存放所有从数据库中读取的每一条记录
public class Table {
	//ServiceInfo s = new ServiceInfo();
	public ArrayList<Service> serviceInfos ;
	public ArrayList<Data> Datas;
	public ArrayList<Program> Programs;
	//ArrayList<ServiceInfo> s = new ArrayList<ServiceInfo>();
	//从数据库中读的记录存放在ArrayList中
	public int size1;
	public int size2;
	public int size3;
	public int sum;
	public int page;
	//add(ServiceInfo);
	//点击add按钮
	public Table(){
		this.serviceInfos = new ArrayList<Service>();
		this.Datas = new ArrayList<Data>();
		this.Programs = new ArrayList<Program>();
	}
	public void addService(Service s){
		serviceInfos.add(s);
		this.size1=this.serviceInfos.size();
	}
	public int addAllService(List<Service> s){
		this.serviceInfos.addAll(s);
		return s.size();
	}
	public void addData(Data d){
		Datas.add(d);
		this.size2 = this.Datas.size();
	}
	public int addAllData(List<Data> l){
		this.Datas.addAll(l);
		return l.size();
	}
	public void addProgram(Program p){
		Programs.add(p);
		this.size3 = this.Programs.size();
	}
	public int addAllProgram(List<Program> li){
		this.Programs.addAll(li);
		return li.size();
	}
	public int getSize1() {
		return size1;
	}
	public int getSize2() {
		return size2;
	}
	public int getSize3() {
		return size3;
	}
	public ArrayList<Service> getServiceInfos(){
		
		return serviceInfos;
	}
	public ArrayList<Data> getDatas(){
		
		return Datas;
	}
	public ArrayList<Program> getPrograms(){
	
	return Programs;
}
	
}
