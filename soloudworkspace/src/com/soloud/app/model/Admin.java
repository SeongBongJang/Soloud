
package com.soloud.app.model;
/**
 * 관리자데이터를 캡슐화한 클래스
 * @author oong
 *
 */
public class Admin {
	/**
	 * 관리자의 아이디
	 */
	private String adminId;
	/**
	 * 관리자의 이름
	 */
	private String adminName;
	/**
	 * 관리자의 비밀번호
	 */
	private String adminPassword;
	/**
	 * 관리자 클래스 오버로딩 생성자
	 * @param adminId 관리자의 아이디
	 * @param adminName 관리자의 이름
	 * @param adminPassword 관리자의 비밀번호
	 */
	public Admin(String adminId, String adminName, String adminPassword) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	/**
	 * 관리자 클래스 기본생성자
	 */
	public Admin() {
		this("ADMINID", "ADMINNAME", "ADMINPASSWORD");
		
	}
	/**
	 * 관리자 클래스 오버로딩 생성자
	 * @param adminId 관리자 아이디
	 * @param adminName 관리자 이름
	 */
	public Admin(String adminId, String adminName) {
		this.adminId = adminId;
		this.adminName = adminName;
	}
	/**
	 * 관리자클래스 오버로딩 생성자
	 * @param adminId 관리자 아이디
	 */
	public Admin(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * getter
	 * @return 관리자 아이디
	 */
	public String getAdminId() {
		return adminId;
	}
	/**
	 * setter
	 * @param adminId 관리자 아이디
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * getter
	 * @return 관리자 이름
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * setter
	 * @param adminName 관리자 이름
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * getter
	 * @return 관리자 비밀번호
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * setter 
	 * @param adminPassword 관리자 비밀번호
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * 관리자객체의 데이터를 문자열화
	 * @return 문자열데이터
	 */
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + "]";
	}
	
}
