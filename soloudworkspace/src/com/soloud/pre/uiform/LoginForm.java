package com.soloud.pre.uiform;
/**
 * �α��ο��� �ʿ��� UI�����͸� ĸ��ȭ�� Ŭ����
 * @author ����
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
