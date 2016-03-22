package testweb.vo;

public class Program {
	private String program_ID;
	private String program_name;
	private String program_describe;
	private String time_upload;
	private String owner_ID;
	private String service_ID;
	public Program(){}
	public Program(String program_ID,String program_name,String program_describe,String time_upload,String owner_ID,String service_id){
		this.program_ID = program_ID;
		this.program_name = program_name;
		this.program_describe = program_describe;
		this.time_upload = time_upload;
		this.owner_ID = owner_ID;
		this.service_ID = service_id;
	}
	public String getProgram_ID() {
		return program_ID;
	}
	public void setProgram_ID(String program_ID) {
		this.program_ID = program_ID;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public String getProgram_describe() {
		return program_describe;
	}
	public void setProgram_describe(String program_describe) {
		this.program_describe = program_describe;
	}
	public String getTime_upload() {
		return time_upload;
	}
	public void setTime_upload(String time_upload) {
		this.time_upload = time_upload;
	}
	/**
	 * @return the owner_ID
	 */
	public String getOwner_ID() {
		return owner_ID;
	}
	/**
	 * @param owner_ID the owner_ID to set
	 */
	public void setOwner_ID(String owner_ID) {
		this.owner_ID = owner_ID;
	}
	/**
	 * @return the service_ID
	 */
	public String getService_ID() {
		return service_ID;
	}
	/**
	 * @param service_ID the service_ID to set
	 */
	public void setService_ID(String service_ID) {
		this.service_ID = service_ID;
	}
	

}
