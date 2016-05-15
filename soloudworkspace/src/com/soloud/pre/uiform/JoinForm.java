package com.soloud.pre.uiform;

public class JoinForm {
	private String id;
	private String domain;
	private String name;
	private String password;
	private String rePassword;
	public JoinForm() {
	}
	public JoinForm(String id, String domain, String name, String password, String rePassword) {
		this.id = id;
		this.domain = domain;
		this.name = name;
		this.password = password;
		this.rePassword = rePassword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	@Override
	public String toString() {
		return "JoinForm [id=" + id + ", domain=" + domain + ", name=" + name
				+ ", password=" + password + ", rePassword=" + rePassword + "]";
	}
}
