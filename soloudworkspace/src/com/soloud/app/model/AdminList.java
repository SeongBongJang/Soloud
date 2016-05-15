package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 관리자의 목록형 클래스
 * @author oong
 *
 */
public class AdminList implements Serializable{
	/**
	 * 시리얼버전 아이디
	 */
	private static final long serialVersionUID = -669496736297868251L;

	/**
	 * Admin객체를 엘리먼트로 하는 ArrayList
	 */
	private ArrayList<Admin> adminList;
	
	
	/**
	 * AdminList 기본생성자
	 */
	public AdminList() {
		this(new ArrayList<Admin>());
	}
	/**
	 * AdminList 오버로딩 생성자
	 * @param adminList 관리자목록
	 */
	public AdminList(ArrayList<Admin> adminList) {
		this.adminList = adminList;
	}

	/**
	 * 관리자를 추가하는 메소드
	 * @param admin 관리자객체
	 * @return 추가 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addAdmin(Admin admin) {
		return this.adminList.add(admin);
	}
	
	/**
	 * 관리자를 추가하는 메소드
	 * @param id 관리자 아이디
	 * @param name 관리자 이름
	 * @param password 관리자 비밀번호
	 * @return 추가 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addAdmin(String id, String name, String password) {
		return adminList.add(new Admin(id, name, password));
	}
	
	/**
	 * 관리자를 삭제하기위한 메소드
	 * @param admin 관리자객체
	 * @return 삭제 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean deleteAdmin(Admin admin) {
		return adminList.remove(admin);
	}
	
	/**
	 * 관리자를 삭제하기위한 메소드
	 * @param id 관리자의 아이디
	 * @return 삭제 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean deleteAdmin(String id) {
		return adminList.remove(this.searchAdminId(id));
	}
	
	/**
	 * 관리자 정보를 수정하기위한 메소드
	 * @param admin 수정할 대상인 객체
	 * @param newAdmin 새롭게 수정할 데이터를 캡슐화한 관리자 객체
	 */
	public void modifyAdmin(Admin admin, Admin newAdmin) {
		Admin adminTemp = this.searchAdminId(admin.getAdminId());
		adminTemp.setAdminName(newAdmin.getAdminName());
		adminTemp.setAdminPassword(newAdmin.getAdminPassword());
	}
	
	/**
	 * 관리자 정보를 수정하기위한 메소드
	 * @param id 관리자 객체를 검색하기위한 색인자
	 * @param newAdmin 새롭게 수정할 데이터를 캡슐화한 관리자 객체
	 */
	public void modifyAdmin(String id, Admin newAdmin) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminName(newAdmin.getAdminName());
		adminTemp.setAdminPassword(newAdmin.getAdminPassword());
	}
	
	/**
	 * 관리자비밀번호를 수정하기위한 메소드
	 * @param id 관리자객체를 검색하기위한 관리자 아이디 
	 * @param newPassword 새롭게 수정할 비밀번호
	 */
	public void modifyAdminPassword(String id, String newPassword) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminPassword(newPassword);
	}
	
	/**
	 * 관리자의 이름을 수정하기위한 메소드
	 * @param id 관리자객체를 검색하기위한 관리자 아이디
	 * @param newName 새롭게 수정할 관리자 이름
	 */
	public void modifyAdminName(String id, String newName) {
		Admin adminTemp = this.searchAdminId(id);
		adminTemp.setAdminName(newName);
	}
	
	/**
	 * 관리자를 검색하기위한 메소드
	 * @param id 관라자 아이디
	 * @return 관리자객체
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
	 * 관리자 객체를 검색하기위한 메소드
	 * @param name 관리자이름
	 * @return 관리자 목록
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
	 * 관리자를 검색하기위한 메소드
	 * @param id 관리자의 아이디
	 * @param password 관리자의 비밀번호
	 * @return 관리자객체
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
	 * @return 관리자목록
	 */
	public ArrayList<Admin> getAdminList() {
		return adminList;
	}
	/**
	 * setter
	 * @param adminList 관리자목록
	 */
	public void setAdminList(ArrayList<Admin> adminList) {
		this.adminList = adminList;
	}
}
