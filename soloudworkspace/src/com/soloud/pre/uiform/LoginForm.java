package com.soloud.pre.uiform;
/**
 * 로그인에서 필요한 UI데이터를 캡슐화한 클래스
 * @author 영진
 *
 */
public class LoginForm {
	private String id;
	private String password;
	public LoginForm(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public LoginForm() {
		this("id","password");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [id=" + id + ", password=" + password + "]";
	}
	
	
	
}
