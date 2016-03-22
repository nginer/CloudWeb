package testweb.vo;

public class User {
	private String user_ID;
	private String user_name;
	private String time_regist;
	private String time_login;
	private String email;
	private String password;
	private String group;
	private String tel;
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTime_regist() {
		return time_regist;
	}
	public void setTime_regist(String time_regist) {
		this.time_regist = time_regist;
	}
	public String getTime_login() {
		return time_login;
	}
	public void setTime_login(String time_login) {
		this.time_login = time_login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
