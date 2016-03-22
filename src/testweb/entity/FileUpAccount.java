package testweb.entity;

public class FileUpAccount {
	private String filename;
	private String faddress;
	private String fauthority;
	private String fdescription;
	
	//根据上传文件的需要改的
	private String username;
	private String nickname;
	private String password;
	private String email;
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	public String getFauthority() {
		return fauthority;
	}
	public void setFauthority(String fauthority) {
		this.fauthority = fauthority;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//
	public void User(String username,String nickname,String password,String email)
	{
		this.nickname = nickname;
		
		this.username = username;
		
		this.password = password;
		
		this.email = email;
	}
	
	
}
