package testweb.entity;

public class ServiceInfo {
	private String ID;
	private String name;
	private String key;
	private String time;
	private String program;
	private String data;
	private String operation;
	private String briefintruction;
	private String status;
	
	public void setID(String ID){
		this.ID=ID;
	}
	public String getID(){
		return ID;	
	}
	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return name;
	}
	public void setKey(String key){
		this.key = key;
	}
	public String getKey(){
		return key;
	}
	public void setBriefintruction(String briefintruction){
		this.briefintruction = briefintruction;
	}
	public String getBriefintruction(){
		return briefintruction;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getTime(){
		return time;
	}
	public void setProgram(String program){
		this.program = program;
	}
	public String getProgram(){
		return program;
	}
	public void setData(String data){
		this.data =data;
	}
	public String getData(){
		return data;
	}
	public void setOperation(String operation){
		this.operation = operation;
	}
	public String getOperation(){
		return operation;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	} 

	
	
	

}
