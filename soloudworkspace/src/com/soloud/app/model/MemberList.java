package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Member의 목록형 클래스
 * @author oong
 *
 */
public class MemberList implements Serializable {
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 7001510803820197605L;

	/**
	 * 회원목록
	 */
	private ArrayList<Member> members;
	
	
	public MemberList() {
		this.members = new ArrayList<Member>();
	}

	public MemberList(ArrayList<Member> members) {
		this.members = members;
	}

	/**
	 * 회원을 목록에 추가하기위한 메소드
	 * @param member Member 객체. 회원정보
	 * @return 추가에대한 성공여부. 성공시 true, 실패시 false리턴
	 */
	public boolean addMember(Member member) {
		return members.add(member);
	}
	
	/**
	 * 회원을 목록에 추가하기위한 메소드
	 * @param id 회원 아이디
	 * @param name 회원이름
	 * @param password 회원의 비밀번호
	 * @return 추가에대한 성공여부. 성공시 true, 실패시 false리턴
	 */
	public boolean addMember(String id, String name, String password) {
		return members.add(new Member(id, name, password));
	}
	
	/**
	 * 회원을 목록으로부터 삭제하기위한 메소드
	 * @param member 삭제대상 Member객체
	 * @return 삭제 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean deleteMember(Member member) {
		return members.remove(member);
	}
	
	/**
	 * 회원을 목록으로부터 삭제하기위한 메소드
	 * @param id 회원의 아이디
	 * @return 삭제 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean deleteMember(String id) {
		return members.remove(searchMemberId(id));
	}
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param id 회원의 아이디
	 * @param newName 수정할 회원의 이름
	 */
	public void modifyMemberName(String id, String newName) {
		Member member = searchMemberId(id);
		member.setName(newName);
	}
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param id 회원 아이디
	 * @param newPassword 회원의 비밀번호
	 */
	public void modifyMemberPassword(String id, String newPassword) {
		Member member = searchMemberId(id);
		member.setPassword(newPassword);
	}
	
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param id 회원아이디
	 * @param newMember 수정할 Member객체, 회원정보
	 */
	public void modifyMember(String id, Member newMember) {
		Member member = searchMemberId(id);
		member.setName(newMember.getName());
		member.setPassword(newMember.getPassword());
		member.setCapacityLimit(newMember.getCapacityLimit());
		member.setUsedCapacity(newMember.getUsedCapacity());
	}
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param id 회원아이디
	 * @param newCapacityLimit 수정할 최대용량치
	 */
	public void modifyMemberCapacityLimit(String id, float newCapacityLimit) {
		Member member = searchMemberId(id);
		member.setCapacityLimit(newCapacityLimit);
	}
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param id 회원아이디
	 * @param newUsedCapacity 수정할 현재 사용용량
	 */
	public void modifyMemberUsedCapacity(String id, float newUsedCapacity) {
		Member member = searchMemberId(id);
		member.setUsedCapacity(newUsedCapacity);
	}
	
	/**
	 * 회원정보를 수정하기위한 메소드
	 * @param member Member객체, 기존 회원정보
	 * @param newMember 수정할 Member객체, 대체할 회원정보
	 */
	public void modifyMember(Member member, Member newMember) {
		members.set(members.indexOf(member), newMember);
	}
	
	/**
	 * 회원정보를 검색하기위한 메소드
	 * @param id 회원 아이디
	 * @return 회원정보
	 */
	public Member searchMemberId(String id) {
		for(int i=0;i<members.size();i++){
			if(members.get(i).getId().equals(id)){
				return members.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 회원정보를 검색하기위한 메소드
	 * @param name 회원이름
	 * @return 회원정목록. 검색결과가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<Member> searchMemberName(String name) {
		ArrayList<Member> members = new ArrayList<Member>();
		for(int i=0;i<this.members.size();i++){
			if(this.members.get(i).getName().equals(name)){
				members.add(this.members.get(i));
			}
		}
		if(members.isEmpty()){
			return null;
		}
		return members;
	}
	
	/**
	 * 회원정보를 검색하기위한 메소드
	 * @param id 회원 아이디
	 * @param password 회원 비밀번호
	 * @return 회원정보
	 */
	public Member searchMember(String id, String password) {
		for(int i=0;i<this.members.size();i++){
			if(this.members.get(i).getPassword().equals(password) && this.members.get(i).getId().equals(id)){
				return this.members.get(i);
			}
		}
		return null;
	}
	/**
	 * getter
	 * @return 회원목록
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
/**
 * setter
 * @param members 회원목록
 */
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
}
