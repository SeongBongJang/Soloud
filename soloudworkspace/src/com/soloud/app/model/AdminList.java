package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �������� ����� Ŭ����
 * @author oong
 *
 */
public class AdminList implements Serializable{
	/**
	 * �ø������ ���̵�
	 */
	private static final long serialVersionUID = -669496736297868251L;

	/**
	 * Admin��ü�� ������Ʈ�� �ϴ� ArrayList
	 */
	private ArrayList<Admin> adminList;
	
	
	/**
	 * AdminList �⺻������
	 */
	public AdminList() {
		this(new ArrayList<Admin>());
	}
	/**
	 * AdminList �����ε� ������
	 * @param adminList �����ڸ��
	 */
	public AdminList(ArrayList<Admin> adminList) {
		this.adminList = adminList;
	}

	/**
	 * �����ڸ� �߰��ϴ� �޼ҵ�
	 * @param admin �����ڰ�ü
	 * @return �߰� ��������. ������ true, ���н� false ����
	 */
	public boolean addAdmin(Admin admin) {
		return this.adminList.add(admin);
	}
	
	/**
	 * �����ڸ� �߰��ϴ� �޼ҵ�
	 * @param id ������ ���̵�
	 * @param name ������ �̸�
	 * @param password ������ ��й�ȣ
	 * @return �߰� ��������. ������ true, ���н� false ����
	 */
	public boolean addAdmin(String id, String name, String password) {
		return adminList.add(new Admin(id, name, password));
	}
	
	/**
	 * �����ڸ� �����ϱ����� �޼ҵ�
	 * @param admin �����ڰ�ü
	 * @return ���� ��������. ������ true, ���н� false ����
	 */
	public boolean deleteAdmin(Admin admin) {
		return adminList.remove(admin);
	}
	
	/**
	 * �����ڸ� �����ϱ����� �޼ҵ�
	 * @param id �������� ���̵�
	 * @return ���� ��������. ������ true, ���н� false ����
	 */
	public boolean deleteAdmin(String id) {
		return adminList.remove(this.searchAdminId(id));
	}
	
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param admin ������ ����� ��ü
	 * @param newAdmin ���Ӱ� ������ �����͸� ĸ��ȭ�� ������ ��ü
	 */
	public void modifyAdmin(Admin admin, Admin newAdmin) {
		Admin adminTemp = this.searchAdminId(admin.getAdminId());
		adminTemp.setAdminName(newAdmin.getAdminName());
		adminTemp.setAdminPassword(newAdmin.getAdminPassword());
	}
	
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param id ������ ��ü�� �˻��ϱ����� ������
	 * @param newAdmin ���Ӱ� ������ �����͸� ĸ��ȭ�� ������ ��ü
	 */
	public void modifyAdmin(String id, Admin newAdmin) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminName(newAdmin.getAdminName());
		adminTemp.setAdminPassword(newAdmin.getAdminPassword());
	}
	
	/**
	 * �����ں�й�ȣ�� �����ϱ����� �޼ҵ�
	 * @param id �����ڰ�ü�� �˻��ϱ����� ������ ���̵� 
	 * @param newPassword ���Ӱ� ������ ��й�ȣ
	 */
	public void modifyAdminPassword(String id, String newPassword) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminPassword(newPassword);
	}
	
	/**
	 * �������� �̸��� �����ϱ����� �޼ҵ�
	 * @param id �����ڰ�ü�� �˻��ϱ����� ������ ���̵�
	 * @param newName ���Ӱ� ������ ������ �̸�
	 */
	public void modifyAdminName(String id, String newName) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminName(newName);
	}
	
	/**
	 * �����ڸ� �˻��ϱ����� �޼ҵ�
	 * @param id ������ ���̵�
	 * @return �����ڰ�ü
	 */
	public Admin searchAdminId(String id) {
		for(int i=0;i<adminList.size();i++){
			if(adminList.get(i).getAdminId().equals(id)){
				return adminList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ������ ��ü�� �˻��ϱ����� �޼ҵ�
	 * @param name �������̸�
	 * @return ������ ���
	 */
	public ArrayList<Admin> searchAdminName(String name) {
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		for(int i=0;i<this.adminList.size();i++){
			if(this.adminList.get(i).getAdminName().equals(name)){
				adminList.add(this.adminList.get(i));
			}
		}
		return adminList;
	}
	
	/**
	 * �����ڸ� �˻��ϱ����� �޼ҵ�
	 * @param id �������� ���̵�
	 * @param password �������� ��й�ȣ
	 * @return �����ڰ�ü
	 */
	public Admin searchAdmin(String id, String password) {
		for(int i=0;i<this.adminList.size();i++){
			if(this.adminList.get(i).getAdminId().equals(id) && this.adminList.get(i).getAdminPassword().equals(password)){
				return this.adminList.get(i);
			}
		}
		return null;
	}
	/**
	 * getter
	 * @return �����ڸ��
	 */
	public ArrayList<Admin> getAdminList() {
		return adminList;
	}
	/**
	 * setter
	 * @param adminList �����ڸ��
	 */
	public void setAdminList(ArrayList<Admin> adminList) {
		this.adminList = adminList;
	}
}
