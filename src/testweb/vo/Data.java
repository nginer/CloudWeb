package testweb.vo;

public class Data {
	private String data_ID;
	private String data_name;
	private String data_describe;
	private String time_upload;
	private String time_lastModify;
	private String owner_ID;
	private String service_ID;
	public Data(){}
	public Data(String data_ID,String data_name,String data_describe,String time_upload, String time_lastModify,String owner_ID,String service_ID){
		this.data_describe = data_describe;
		this.data_ID = data_ID;
		this.data_name = data_name;
		this.time_upload = time_upload;
		this.time_lastModify = time_lastModify;
		this.owner_ID = owner_ID;
		this.service_ID = service_ID;
	}
	public String getData_ID() {
		return data_ID;
	}
	public void setData_ID(String data_ID) {
		this.data_ID = data_ID;
	}
	public String getData_name() {
		return data_name;
	}
	public void setData_name(String data_name) {
		this.data_name = data_name;
	}
	public String getData_describe() {
		return data_describe;
	}
	public void setData_describe(String data_describe) {
		this.data_describe = data_describe;
	}
	public String getTime_upload() {
		return time_upload;
	}
	public void setTime_upload(String time_upload) {
		this.time_upload = time_upload;
	}
	public String getTime_lastModify() {
		return time_lastModify;
	}
	public void setTime_lastModify(String time_lastModify) {
		this.time_lastModify = time_lastModify;
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
