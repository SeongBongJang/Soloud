
package com.soloud.app.model;
/**
 * �����ڵ����͸� ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class Admin {
	/**
	 * �������� ���̵�
	 */
	private String adminId;
	/**
	 * �������� �̸�
	 */
	private String adminName;
	/**
	 * �������� ��й�ȣ
	 */
	private String adminPassword;
	/**
	 * ������ Ŭ���� �����ε� ������
	 * @param adminId �������� ���̵�
	 * @param adminName �������� �̸�
	 * @param adminPassword �������� ��й�ȣ
	 */
	public Admin(String adminId, String adminName, String adminPassword) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	/**
	 * ������ Ŭ���� �⺻������
	 */
	public Admin() {
		this("ADMINID", "ADMINNAME", "ADMINPASSWORD");
		
	}
	/**
	 * ������ Ŭ���� �����ε� ������
	 * @param adminId ������ ���̵�
	 * @param adminName ������ �̸�
	 */
	public Admin(String adminId, String adminName) {
		this.adminId = adminId;
		this.adminName = adminName;
	}
	/**
	 * ������Ŭ���� �����ε� ������
	 * @param adminId ������ ���̵�
	 */
	public Admin(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * getter
	 * @return ������ ���̵�
	 */
	public String getAdminId() {
		return adminId;
	}
	/**
	 * setter
	 * @param adminId ������ ���̵�
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * getter
	 * @return ������ �̸�
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * setter
	 * @param adminName ������ �̸�
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * getter
	 * @return ������ ��й�ȣ
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * setter 
	 * @param adminPassword ������ ��й�ȣ
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * �����ڰ�ü�� �����͸� ���ڿ�ȭ
	 * @return ���ڿ�������
	 */
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + "]";
	}
	
}
