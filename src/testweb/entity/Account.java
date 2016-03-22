package testweb.entity;

public class Account {
	private String username;
	
	private String password;

	private String loginway;//登录方式
	
	private String captcha;//验证码

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

	public String getLoginway() {
		return loginway;
	}

	public void setLoginway(String loginway) {
		this.loginway = loginway;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
