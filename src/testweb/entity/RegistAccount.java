package testweb.entity;

public class RegistAccount {
	private String username;	
	private String email;
	private String password;
	private String  qupassword;
	private String mobilephone;
	private String registerway;	

	//用户名称username
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//密码password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQupassword() {
		return qupassword;
	}

	public void setQupassword(String qupassword) {
		this.qupassword = qupassword;
	}

	public String getMobilphone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getRegisterway() {
		return registerway;
	}

	public void setRegisterway(String registerway) {
		this.registerway = registerway;
	}
	
}
